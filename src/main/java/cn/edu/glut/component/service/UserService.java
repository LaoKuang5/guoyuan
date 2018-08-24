package cn.edu.glut.component.service;

import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
/**
 * 
 * @author 于金彪
 *
 */
public interface UserService {
	/**
	 * 发送短信验证码 
	 * @param tel 手机号
	 * @param checkCode 短信验证码
	 * @return 成功 true 失败返回false 出错  记录日志
	 */
	boolean smsCode(String tel,String checkCode);

	/**
	 * 用户注册功能
	 * @param userGrant
	 * @return
	 */
	UserInfo regist(UserGrant userGrant);
	
}
