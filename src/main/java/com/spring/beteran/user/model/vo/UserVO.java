package com.spring.beteran.user.model.vo;

public class UserVO {
	private String userid, username, pwd, gender, birth, email, address;

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String userid, String username, String pwd, String gender, String birth, String email,
			String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.address = address;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
