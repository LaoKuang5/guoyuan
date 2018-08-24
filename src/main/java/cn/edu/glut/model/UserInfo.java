package cn.edu.glut.model;
/**
 * 实体类
 * @author jones
 *
 */
public class UserInfo {
	private int user_id;
	
	private String telephone;
	
	private String nickname;
	
	private String identity_num;
	
	private String photo;
	
	private int state;
	
	private String  address;
	
	private String ip;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIdentity_num() {
		return identity_num;
	}

	public void setIdentity_num(String identity_num) {
		this.identity_num = identity_num;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	
}
