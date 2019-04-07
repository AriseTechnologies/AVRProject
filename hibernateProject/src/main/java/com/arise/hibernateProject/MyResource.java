package com.arise.hibernateProject;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	@POST
	@Path("/signup")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String signup(UserRequest req) {
		Session session = HibernateUtil.getSessionFactory().openSession();

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

		Transaction trx = session.beginTransaction();
		session.save(u);
		trx.commit();
		return "Done";
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(UserRequest req) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		UsersEntity u = (UsersEntity) session.get(UsersEntity.class,
				req.getUserId());
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
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(UserRequest req) {

		UserResponse res = new UserResponse();
		List<Error> errors = AVRValidator.validate(req);

		if (!errors.isEmpty()) {
			res.setErrList(errors);
			return Response.status(400).entity(res).build();
		}

		Session session = HibernateUtil.getSessionFactory().openSession();

		UsersEntity usr = (UsersEntity) session.get(UsersEntity.class, req.getUserId());
		if (null != usr) {
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
				usr.setUserNm(req.getUserNm());
			}
			Transaction trx = session.beginTransaction();
			session.update(usr);
			trx.commit();
			res.setUserId(req.getUserId());
		} else {
			String msg = "User does not exist, please signup";
			Error err = new Error();
			err.setMsg(msg);
			errors.add(err);
			res.setErrList(errors);
		}

		return Response.status(200).entity(res).build();
	}
	
	@DELETE
	@Path("/deactivate")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deactivateUser(@QueryParam("userId") String userId) {

		UserRequest req = new UserRequest();
		req.setUserId(userId);
//		String validFlag = AVRValidator.validate(req);
//		if (!"OK".equals(validFlag)) {
//			return validFlag;
//		}

		Session session = HibernateUtil.getSessionFactory().openSession();

		UsersEntity user = session.get(UsersEntity.class, userId);
		String msg;
		if (null != user) {
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			msg = "User " + userId + " deactivated successfully";
		} else {
			msg = "User " + userId + " does not exist";
		}

		return msg;
	}
	
	@POST
	@Path("/ownerFill")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ownerData(HotelRequest req) {
		HotelResponse hr = new HotelResponse();
		
		HotelEntity hotel = new HotelEntity();
		hotel.setHotelName(req.getHotelName());
		hotel.setOwnerNm(req.getOwnerNm());
		hotel.setOwnEmailId(req.getOwnEmailId());
		hotel.setOwnMobNo(req.getOwnMobNo());
		hotel.setRating(req.getRating());
		hotel.setFlats(req.getFlats());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.save(hotel);
		trx.commit();
		
		hr.setHotelName(req.getHotelName());
		hr.setOwnerNm(req.getOwnerNm());
		
		return Response.status(200).entity(hr).build();
	}

	
}
