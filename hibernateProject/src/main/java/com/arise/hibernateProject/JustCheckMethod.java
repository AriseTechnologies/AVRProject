package com.arise.hibernateProject;

public class JustCheckMethod {

	public static void main(String[] args) {
		String providedPwd = "ums@12345";
		String securePwd = "9OrhJ+/yqMa28tj4xPpSmwBUjkdzSjlMy1+7ARwqWCk=";
		String saltvalue = "FfTVDKguOQF6KQSzd6uTNTFdyOQnnN";
//		String salt = PasswordUtils.getSalt(30);
//		String mySecurePwd = PasswordUtils.generateSecurePassword(providedPwd, salt);
		
		boolean match = PasswordUtils.verifyUserPassword(providedPwd, securePwd, saltvalue);
		if(match){
		System.out.println("password "+providedPwd+" is correct");
		}else{
			System.out.println("password "+providedPwd+" is wrong");
		}
		}
}
