package com.arise.hibernateProject.handler;

import java.util.List;

import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arise.hibernateProject.entity.JustEntity;
import com.arise.hibernateProject.entity.UsersEntity;
import com.arise.hibernateProject.payload.UserRequest;
import com.arise.hibernateProject.payload.UserResponse;
import com.arise.hibernateProject.util.AVRValidator;
import com.arise.hibernateProject.util.Error;
import com.arise.hibernateProject.util.HibernateUtil;
import com.arise.hibernateProject.util.PasswordUtils;

public class UserServiceHandler {

	/*
	 * Method to signUp for new User
	 */
	public static Response signUp(UserRequest req) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		UserResponse res = new UserResponse();
		List<Error> errors = AVRValidator.validate(req);

		if (!errors.isEmpty()) {
			res.setErrList(errors);
			return Response.status(400).entity(res).build();
		}

		String salt = PasswordUtils.getSalt(30);
		String pwd = PasswordUtils.generateSecurePassword(req.getPassword(),
				salt);
		UsersEntity u = new UsersEntity();
		u.setUserId(req.getUserId());
		u.setUserNm(req.getUserNm());
		u.setPassword(pwd);
		u.setSaltValue(salt);
		u.setEmail(req.getEmail());
		u.setMobNo(req.getMobNo());
		u.setDeactivate("N");		//setting value N for new user
		
		JustEntity j = new JustEntity();
		j.setName("just");

		Transaction trx = session.beginTransaction();
		session.save(u);
		session.save(j);
		trx.commit();
		res.setUserId(req.getUserId());

		return Response.status(200).entity(res).build();
	}

	/*
	 * Method to login for existing users
	 */
	public static String login(UserRequest req) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsersEntity u = (UsersEntity) session.get(UsersEntity.class,
				req.getUserId());
		// validating if user is deactivated or not
		if (null != u && null != u.getDeactivate() && "Y".equals(u.getDeactivate())) {
			return "USer is deactivated, Please reactivate";
		}
		boolean match = false;
		if (null != u) {
			match = PasswordUtils.verifyUserPassword(req.getPassword(),
					u.getPassword(), u.getSaltValue());
		}
		String output;
		if (match) {
			output = "Succefully logged";
		} else {
			output = "Either username or password is invalid";
		}
		return output;
	}

	/*
	 * Method to update existing user's data
	 */
	public static Response update(UserRequest req) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UserResponse res = new UserResponse();
		List<Error> errors = AVRValidator.validate(req);

		if (!errors.isEmpty()) {
			res.setErrList(errors);
			return Response.status(400).entity(res).build();
		}
		
		UsersEntity usr = (UsersEntity) session.get(UsersEntity.class,
				req.getUserId());
		
		if (null != usr) {
			if (null != usr.getDeactivate() && "Y".equals(usr.getDeactivate())) {
				String msg = "User is deactivated and can't update";
				Error err = new Error();
				err.setMsg(msg);
				errors.add(err);
				res.setErrList(errors);
			} else {
				if (null != req.getUserId()) {
					usr.setUserId(req.getUserId());
				}
				if (null != req.getUserNm()) {
					usr.setUserNm(req.getUserNm());
				}
				if (null != req.getEmail()) {
					usr.setEmail(req.getEmail());
				}
				if (null != req.getMobNo()) {
					usr.setMobNo(req.getMobNo());
				}
				Transaction trx = session.beginTransaction();
				session.update(usr);
				trx.commit();
				res.setUserId(req.getUserId());
			}
		} else {
			String msg = "User does not exist, please signup";
			Error err = new Error();
			err.setMsg(msg);
			errors.add(err);
			res.setErrList(errors);
		}

		return Response.status(200).entity(res).build();
	}

	/*
	 * Method to deactivate user
	 */
	public static String deactivateUser(String userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsersEntity user = session.get(UsersEntity.class, userId);
		String msg;
		if (null != user) {
			Transaction tx = session.beginTransaction();
			user.setDeactivate("Y");
			session.update(user);
			tx.commit();
			msg = "User " + userId + " deactivated successfully";
		} else {
			msg = "User " + userId + " does not exist";
		}

		return msg;

	}
}
