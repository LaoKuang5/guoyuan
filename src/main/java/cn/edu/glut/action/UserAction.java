package cn.edu.glut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import cn.edu.glut.component.service.UserService;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;

/**
 * 
 * @author 于金彪
 *
 */
@Controller
@RequestMapping(value = "user")
public class UserAction {

	@Resource(name = "userService")
	UserService userService;
	
	Logger log=LogManager.getLogger();
	Logger record=LogManager.getLogger("recordFile");
	/**
	 * 发送验证码的方法
	 * 
	 * @param tel      手机号必传
	 * @param regist   注册时必传,值为true。其他情况可省略
	 * @param response
	 * @param session
	 * @return 短信发送成功返回true 发送失败返回false。注册时失败返回错误号,1001：手机号已注册
	 * 
	 */
	@RequestMapping(value = "smsCode")
	public String smsCode(@RequestParam(name = "tel", required = true) String tel,
			@RequestParam(name = "regist") String regist, HttpServletResponse response, HttpSession session) {
		// 设置response 文本类型
		response.setContentType("text/html;charset=utf-8");
		try {
			// 如果是注册先判断手机号
			if (regist != null && regist.contains("true")) {
				UserInfo user = userService.getUserByTel(tel);
				if (user != null) {
					response.getWriter().println("1001");
					return null;
				}
			}

			Random random = new Random();
			// 保证验证码6位数
			SendSmsResponse sendSms = null;
			int checkCode = random.nextInt(899999) + 100000;
			PrintWriter pw = null;
			//验证码发送结果 成功true 
			boolean flag = userService.smsCode(tel, String.valueOf(checkCode));

			pw = response.getWriter();
			if (flag) {
				session.setAttribute("tel", tel);
				session.setAttribute("checkCode", String.valueOf(checkCode));
				pw.println("true");
			} else {
				pw.print("false");
			}
		} catch (IOException e) {
			log.error("IOException",e);
		}

		return null;
	}

	
	/**
	 * 
	 * 校验验证码
	 * 
	 * @param smsCode
	 * @param resp
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "checkSMSCode")
	public String checkSMSCode(@RequestParam(name = "smsCode", required = true) String smsCode,
			HttpServletResponse resp, HttpSession session) {
		try {
			// 先验证是否发送了验证码
			String tel = (String) session.getAttribute("tel");
			if (tel == null) {
				resp.getWriter().println("noTelephoneNumber");
				
				return null;
			}
			// 校验验证码页面对验证码进行非空验证
			String checkCode = (String) session.getAttribute("checkCode");
			if (smsCode != null && smsCode.equals(checkCode)) {
				resp.getWriter().println("true");
				// 已通过手机号验证
				session.setAttribute("validTelephone", true);
				return null;
			} else {
				resp.getWriter().println("false");
				return null;
			}
		} catch (IOException e) {
			log.error("IOException",e);
		}

		return null;
	}

	
	
	/**
	 * 注册功能账号是已验证的手机号
	 * 
	 * @param pwd     密码
	 * @param request
	 * @param session
	 * @return 返回页面路径待定
	 */
	@RequestMapping(value = "regist")
	public ModelAndView regist(@RequestParam(name = "pwd", required = true) String pwd, HttpServletRequest request,
			HttpSession session) {
		String tel = (String) session.getAttribute("tel");
		if (tel == null) {
			// 不应该进到此处 记录日志
			record.debug("手机号未发送过验证码");
			return null;
		}

		// 确保经过手机号验证
		Boolean checked = (Boolean) session.getAttribute("validTelephone");

		// 未经过手机号验证 正常情况不会出现 一旦出现记录日志
		if (checked == null || !checked) {
			// 记录日志
			record.debug("手机未经过验证码验证");
			return null;
		}

		ModelAndView mv = new ModelAndView();
		UserInfo user = new UserInfo();
		UserGrant userGrant = new UserGrant();

		// 记录注册ip地址
		user.setIp(request.getRemoteAddr());

		// 调用service 层通过ip地址查出地理位置 未完成
		user.setTelephone(tel);
		// 用户状态 约定0禁止登陆 1允许登陆
		user.setState(1);

		userGrant.setLoginType("telephone");
		userGrant.setGrantCode(pwd);
		userGrant.setIdentifier(tel);
		userGrant.setUser(user);

		// 调用service 进行注册
		user = userService.regist(userGrant);

		if (user == null || user.getUserId() == null) {
			// *******出错记录日志
			log.error("用户注册失败:"+tel);
		} else {
			//注册成功 修改视图
		}
		return mv;
	}

	
	/**
	 * 手机+密码的登陆方式
	 * @param tel 手机号
	 * @param pwd 密码
	 * @param session 
	 * @return 成功返回我的页面 失败提示错误信息
	 */
	@RequestMapping(value="login")
	public ModelAndView login(@RequestParam(name="tel") String tel,@RequestParam(name="pwd") String pwd,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		UserGrant userGrant=userService.getUserGrantByTel(tel);
		if(userGrant==null) {
			//手机号为空 返回error  修改视图
			mv.setViewName("");
			mv.addObject("error", "");
			System.out.println("手机号错误");
			return mv;
		}else {
			if(userGrant.getGrantCode().equals(pwd)) {
				mv.setViewName("");
				mv.addObject("ok", "");
				System.out.println("登陆成功");
				//信息添加到session
				//这里 返回
				return mv;
			}else {
				//修改视图
				mv.setViewName("");
				mv.addObject("error", "");
				System.out.println("密码错误");
				//这里 返回
				return mv;
			}
			
		}
		
	}

}
