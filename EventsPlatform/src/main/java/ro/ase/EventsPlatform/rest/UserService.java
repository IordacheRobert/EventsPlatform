package ro.ase.EventsPlatform.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ro.ase.EventsPlatform.dao.UserDao;
import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.User;

@Path("users")
public class UserService {

	private UserDao userDao = new UserDao();
	private ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("events request");
		return Response
				.ok(mapper.writeValueAsBytes(userDao.getAll()))
				.build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") String id)
			throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException {
			
		return Response
				.ok(mapper.writeValueAsString(userDao.getObject(Integer.parseInt(id))))
				.build();

	}

	@GET
	@Path("{id}/events")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserEventsById(@PathParam("id") String id)
			throws JsonGenerationException, JsonMappingException, NumberFormatException, IOException {

		return Response
				.ok(mapper.writeValueAsString(userDao.getMyEvents(Integer.parseInt(id))))
				.build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveUser(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		User temp = mapper.readValue(json, User.class);

		return Response
				.ok(mapper.writeValueAsString(userDao.saveObject(temp)))
				.build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserById(@PathParam("id") String id) {

		userDao.deleteObject(Integer.parseInt(id));
		return Response
				.ok().build();

	}
	
	
	@POST
	@Path("{id}/events")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postEventToUser(String json,@PathParam("id") String id) 
			throws JsonParseException, JsonMappingException, IOException{
		
		Event event=mapper.readValue(json,Event.class);
		userDao.addEventToUser(Integer.parseInt(id),event);
		
		return Response.ok("works").build();
	}
	
	

}
