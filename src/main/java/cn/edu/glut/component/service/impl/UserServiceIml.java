package cn.edu.glut.component.service.impl;

import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.component.service.UserService;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.SendSMSCode;
//           ↓ bean id
@Service("userService")
public class UserServiceIml implements UserService{

	
	@Override
	public boolean smsCode(String tel, String checkCode) {
		try {
			SendSmsResponse sendSms = SendSMSCode.sendSms(tel, checkCode);
			if(sendSms!=null&&sendSms.getCode().equals("OK")) {
				return true;
			}
		} catch (ClientException e) {
			
			//***完善日志功能后加入日志**********
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserInfo regist(UserGrant userGrant) {
		//调用dao层保存 数据
		return null;
	}

	
	
}
