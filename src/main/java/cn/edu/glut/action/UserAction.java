package cn.edu.glut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.HttpRequest;

import cn.edu.glut.component.service.UserService;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.SendSMSCode;
@Controller
@RequestMapping(value="user")
public class UserAction {
	
	@Resource(name="userService")
	UserService userService;
	
	/**
	 * 发送验证码的方法 参数tel 必传.此方法通过ajax调用成功返回true 失败返回false
	 * @return
	 */
	@RequestMapping(value="smsCode" )
	public String smsCode(@RequestParam(name="tel",required=true) String tel,HttpServletResponse response,HttpSession session ) {
		//设置response 文本类型
		response.setContentType("text/html;charset=utf-8");
		//不对tel 进行合法判断 充分信任前端 直接调用api 发送验证码
		Random random=new Random();
		//保证验证码6位数
		SendSmsResponse sendSms=null;
		int checkCode=random.nextInt(899999)+100000; 
		PrintWriter pw=null;
		boolean  flag=userService.smsCode(tel, String.valueOf(checkCode));
		try {
			pw=response.getWriter();
			if(flag) {
				session.setAttribute("tel", tel);
				session.setAttribute("checkCode", String.valueOf(checkCode));
				pw.println("true");
			}else {
				pw.print("false");
			}
		} catch (IOException e) {
			// *********完善日志功能后加入日志************
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 验证码先行
	 * @param smsCode
	 * @param resp
	 * @param session
	 * @return
	 */
	@RequestMapping(value="checkSMSCode")
	public String checkSMSCode(@RequestParam(name="smsCode",required=true) String smsCode,HttpServletResponse resp,HttpSession session) {
		try {
			//先验证是否发送了验证码
			String tel=(String) session.getAttribute("tel");
			if(tel==null) {
				resp.getWriter().println("noTelephoneNumber");
				//**********记录日志************
				return null;
			}
			//校验验证码页面对验证码进行非空验证
			String checkCode=(String) session.getAttribute("checkCode");
			if(smsCode!=null&&smsCode.equals(checkCode)) {
				resp.getWriter().println("true");
				//已通过手机号验证
				session.setAttribute("validTelephone", true);
				return null;
			}else {
				resp.getWriter().println("false");
				return null;
			}
		}catch(IOException e) {
			//****完善日志后加入日志 
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 注册功能账号是已验证的手机号 
	 * 返回页面路径待定
	 * @return
	 */
	@RequestMapping(value="regist")
	public ModelAndView regist(@RequestParam(name="pwd",required=true)String pwd,HttpServletRequest request,HttpSession session) {
		String tel=(String) session.getAttribute("tel");
		if(tel==null) {
			//不应该进到此处 记录日志
			return null;
		}
		
		//确保经过手机号验证
		Boolean checked=(Boolean) session.getAttribute("validTelephone");
		
		//未经过手机号验证 正常情况不会出现 一旦出现记录日志
		if(checked==null||!checked) {
			//记录日志
			return null;
		}
		
		ModelAndView mv=new ModelAndView();
		UserInfo user=new UserInfo();
		UserGrant userGrant=new UserGrant();
		
		//记录注册ip地址
		user.setIp(request.getLocalAddr());
		
		//调用service 层通过ip地址查出地理位置  未完成
		user.setTelephone(tel);
		//用户状态 约定0禁止登陆 1允许登陆
		user.setState(1);
		
		userGrant.setLoginType("telephone");
		userGrant.setGrantCode(pwd);
		userGrant.setIdentifier(tel);
		userGrant.setUser(user);
		
		//调用service 进行注册
		user=userService.regist(userGrant);
		
		return mv;
	}
}
