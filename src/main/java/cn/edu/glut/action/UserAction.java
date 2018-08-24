package cn.edu.glut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.util.SendSMSCode;
@Controller
@RequestMapping(value="user")
public class UserAction {
	
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
		try {
			pw=response.getWriter();
			sendSms = SendSMSCode.sendSms(tel, checkCode+"");
			
			if(sendSms!=null&&sendSms.getCode().equals("ok")) {
				//手机号和验证码加入到session
				session.setAttribute("tel", tel);
				session.setAttribute("checkCode", String.valueOf(checkCode));
				pw.println("true");
				return null;
			}else {
				//*****待完善日志功能后加入日志******
				System.out.println("阿里云短信api返回异常");
				pw.println("false");
				return null;
			}
		}catch ( ClientException e) {
			//*****待完善日志功能后加入日志******
			System.out.println(e.getErrMsg());
			pw.print("false");
			
		} catch (IOException e) {
			//*****待完善日志功能后加入日志******
			e.printStackTrace();
		}
		
		return null;
	}
}
