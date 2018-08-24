package cn.edu.glut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.component.service.UserService;
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
	 * 验证码先行 验证码匡 每次改变ajax请求验证  成功返回true 失败返回false
	 * @return
	 */
	@RequestMapping(value="checkSMSCode")
	public String checkSMSCode(@RequestParam(name="tel",required=true) String tel,@RequestParam(name="smsCode",required=true) String smsCode,HttpServletResponse resp,HttpSession session) {
		try {
			if(tel!=null&&smsCode!=null) {
				if(tel.equals(session.getAttribute("tel"))&&smsCode.equals(session.getAttribute("checkCode"))) {
					resp.getWriter().println("true");
					return null;
				}
			}
			resp.getWriter().println("false");
		}catch(IOException e) {
			//****完善日志后加入日志 
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String regist() {
		return null;
	}
}