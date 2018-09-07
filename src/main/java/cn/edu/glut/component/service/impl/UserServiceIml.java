package cn.edu.glut.component.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.component.dao.UserDao;
import cn.edu.glut.component.service.UserService;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.SendSMSCode;
//           ↓ bean id
@Service("userService")
public class UserServiceIml implements UserService{

	Logger log=LogManager.getLogger();
	@Resource
	UserDao userDao;
	
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
			log.error("ClientException",e);
		}
		return false;
	}

	@Override
	public UserInfo regist(UserGrant userGrant , UserInfo user) {
		//调用dao层保存,先保存userinfo,再保存userGrant
		userDao.addUserInfo(user);
		userDao.addUserGrant(userGrant);
		List<UserGrant> grants=new ArrayList<>();
		grants.add(userGrant);
		user.setGrants(grants);
		
		
		return user;
	}

	@Override
	public UserInfo getUserByTel(String tel) {
		
		return userDao.getUserByTel( tel);
	}

	@Override
	public UserGrant getUserGrantByTel(String tel) {
		
		return userDao.getUserGrantByTel(tel);
	}

	
	
}
