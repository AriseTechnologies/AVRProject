package com.arise.hibernateProject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "APR_USER")
public class UsersEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USR_ID")
	private String userId;

	@Column(name = "USR_NM")
	private String userNm;
	
	@Column(name = "PWD")
	private String password;
	
	@Column(name="SALT")
	private String saltValue;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOB_NO")
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
	

	public String getSaltValue() {
		return saltValue;
	}

	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNm=" + userNm + ", password="
				+ password + ", email=" + email + ", mobNo=" + mobNo + "]";
	}
	
	

}
