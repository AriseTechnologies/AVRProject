package com.arise.hibernateProject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class UserRequest extends BaseRequest{

	@NotNull(message="Please enter valid ID")
	private String userId;

	private String userNm;
	
	@NotNull(message="Mandetory field password")
	private String password;
	
	private String email;

	@NotNull(message="Mandetory field mobile number")
	@Pattern(regexp = "^[a-zA-Z0-9]{10}$", message="Enter valid mobile number")
	private String mobNo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
}
