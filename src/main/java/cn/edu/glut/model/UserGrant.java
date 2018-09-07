package cn.edu.glut.model;
/**
 * 用户授权表 有疑问联系 ↓
 * @author     于金彪
 *
 */
public class UserGrant {
	private Integer userGrantId;
	
	//此处对应表中 属性UserId
	private Integer userId;
	
	//登录类型 手机号 QQ 微信....
	private String loginType;
	
	private String grantCode;
	
	//身份码 手机号 微信识别码 等等 
	private String identifier;

	public Integer getUserGrantId() {
		return userGrantId;
	}

	public void setUserGrantId(Integer userGrantId) {
		this.userGrantId = userGrantId;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getGrantCode() {
		return grantCode;
	}

	public void setGrantCode(String grantCode) {
		this.grantCode = grantCode;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	
	
}
