package com.arise.hibernateProject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.arise.hibernateProject.handler.HotelServiceHandler;
import com.arise.hibernateProject.handler.UserServiceHandler;
import com.arise.hibernateProject.payload.HotelRequest;
import com.arise.hibernateProject.payload.UserRequest;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	@POST
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response signup(UserRequest req) {
		return UserServiceHandler.signUp(req);
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(UserRequest req) {

		return UserServiceHandler.login(req);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(UserRequest req) {
		return UserServiceHandler.update(req);
	}

	@PUT
	@Path("/deactivate")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deactivateUser(@QueryParam("userId") String userId) {
		return UserServiceHandler.deactivateUser(userId);
	}

	@POST
	@Path("/adminSignUp")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ownerData(HotelRequest req) {
		return HotelServiceHandler.adminUserEntry(req);
	}
	
	@GET
	@Path("/hotelDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHotelDetails(@QueryParam("hotelName") String hotelName) {
		return HotelServiceHandler.getHotelDetails(hotelName);
	}
	
	@PUT
	@Path("/adminUpdate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adminUserUpdate(HotelRequest req) {
		return HotelServiceHandler.adminUserUpdate(req); // not implemented fully yet
	}

}
