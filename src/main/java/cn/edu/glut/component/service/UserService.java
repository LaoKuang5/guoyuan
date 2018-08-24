package cn.edu.glut.component.service;


public interface UserService {
	/**
	 * 发送短信验证码 成功 true 出错  记录日志
	 * @param tel 手机号
	 * @param checkCode 短信验证码
	 * @return
	 */
	boolean smsCode(String tel,String checkCode);
}
