package ro.ase.EventsPlatform.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ro.ase.EventsPlatform.dao.EventTypeDao;
import ro.ase.EventsPlatform.model.EventType;

@Path("eventtypes")
public class EventTypeService {

	private EventTypeDao eventTypeDao = new EventTypeDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventTypes() {

		GenericEntity<List<EventType>> entity = new GenericEntity<List<EventType>>(eventTypeDao.getAll()) {
		};

		return Response.ok(entity, MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveEventType(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		EventType temp = mapper.readValue(json, EventType.class);
		return Response.ok(eventTypeDao.saveObject(temp)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEventType(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		EventType temp = mapper.readValue(json, EventType.class);

		return Response.ok(eventTypeDao.updateObject(temp)).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEventTypeById(String json, @PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		EventType temp = mapper.readValue(json, EventType.class);
		temp.setId(Integer.parseInt(id));
		return Response.ok(eventTypeDao.updateObject(temp)).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventTypeById(@PathParam("id") String id) {

		return Response.ok(eventTypeDao.getObject(Integer.parseInt(id))).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEventTypeById(@PathParam("id") String id) {

		eventTypeDao.deleteObject(Integer.parseInt(id));
		return Response.ok().build();

	}

}
