package ro.ase.EventsPlatform.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

import ro.ase.EventsPlatform.dao.EventDao;
import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.User;

@Path("events")
public class EventService {
	
	EventDao hibernate=new EventDao();
	ObjectMapper mapper=new ObjectMapper();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents() 
			throws JsonGenerationException, JsonMappingException, IOException{
	
		List<Event> eventsList=hibernate.getAll(); 
		return Response.ok(mapper.writeValueAsString(eventsList)).build();
		
	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventByID(@PathParam("id") String id)
			throws JsonGenerationException, JsonMappingException, IOException{
		
		Event event=hibernate.getObject(Integer.parseInt(id));
		return Response.ok(mapper.writeValueAsString(event)).build();
	}
	

	@GET
	@Path("{id}/organizer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrganizerEventByID(@PathParam("id") String id)
			throws JsonGenerationException, JsonMappingException, IOException{
		
		User organizer=hibernate.getObject(Integer.parseInt(id)).getOrganizer();
		return Response.ok(mapper.writeValueAsString(organizer)).build();
	}
	
	
	@GET
	@Path("{id}/participants")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParticipantsEventByID(@PathParam("id") String id) 
			throws JsonGenerationException, JsonMappingException, IOException{
		
		List<User> listParticipants=hibernate.getObject(Integer.parseInt(id)).getParticipants();
		return Response.ok(mapper.writeValueAsString(listParticipants)).build();
	}
	
	
	
}
