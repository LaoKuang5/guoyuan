package cn.edu.glut.component.service.impl;

import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.component.service.UserService;
import cn.edu.glut.util.SendSMSCode;
//           ↓ bean id
@Service("userService")
public class UserServiceIml implements UserService{

	@Override
	public boolean smsCode(String tel, String checkCode) {
		try {
			SendSmsResponse sendSms = SendSMSCode.sendSms(tel, checkCode);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
