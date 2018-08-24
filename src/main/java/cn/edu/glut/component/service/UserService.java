package cn.edu.glut.component.service;


public interface UserService {
	/**
	 * 发送短信验证码 
	 * @param tel 手机号
	 * @param checkCode 短信验证码
	 * @return 成功 true 失败返回false 出错  记录日志
	 */
	boolean smsCode(String tel,String checkCode);
	
}
