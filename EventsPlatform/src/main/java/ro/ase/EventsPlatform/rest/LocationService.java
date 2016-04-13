package ro.ase.EventsPlatform.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
import org.hibernate.HibernateException;

import ro.ase.EventsPlatform.dao.LocationDao;
import ro.ase.EventsPlatform.model.Location;

@Path("locations")
public class LocationService {

	private LocationDao locationDao = new LocationDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocations() {

		GenericEntity<List<Location>> entity = new GenericEntity<List<Location>>(locationDao.getAll()) {
		};

		return Response.ok(entity, MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveLocation(String json)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Location temp = mapper.readValue(json, Location.class);
		return Response.ok(locationDao.saveObject(temp)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLocation(String json)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Location temp = mapper.readValue(json, Location.class);

		return Response.ok(locationDao.updateObject(temp)).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateLocationById(String json, @PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Location temp = mapper.readValue(json, Location.class);
		temp.setId(Integer.parseInt(id));
		return Response.ok(locationDao.updateObject(temp)).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocationById(@PathParam("id") String id) {

		return Response.ok(locationDao.getObject(Integer.parseInt(id))).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLocationById(@PathParam("id") String id) {

		locationDao.deleteObject(Integer.parseInt(id));
		return Response.ok().build();

	}

}
