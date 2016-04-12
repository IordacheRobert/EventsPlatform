package ro.ase.EventsPlatform.rest;

import java.io.IOException;
import java.util.Date;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ro.ase.EventsPlatform.dao.EventDao;
import ro.ase.EventsPlatform.dao.LocationDao;
import ro.ase.EventsPlatform.dao.UserDao;
import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.EventType;
import ro.ase.EventsPlatform.model.Location;
import ro.ase.EventsPlatform.model.User;


@Path("demo")
public class demo {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDemo()	{
		return "Works!";
	}
	
	@GET
	@Path("location")
	@Produces(MediaType.APPLICATION_JSON)
	public Location getLocation()	{
		return new LocationDao().getObject(11);
	}

	@GET
	@Path("locationtxt")
	@Produces(MediaType.TEXT_PLAIN)
	public String getLocationTxt() throws JsonGenerationException, JsonMappingException, IOException	{
		return new ObjectMapper().writeValueAsString(new LocationDao().getObject(11));
	}
	
	@GET
	@Path("event")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEvent()	{
		Event temp=new EventDao().getObject(25);
		
		System.out.println(temp.toString());
		
		return temp;
	}
	
	@GET
	@Path("eventtxt")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEventTxt() throws JsonGenerationException, JsonMappingException, IOException	{
		Event temp=new EventDao().getObject(5);
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(temp);
	}
	
	@GET
	@Path("usertxt")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserTxt() throws JsonGenerationException, JsonMappingException, IOException	{
		User temp=new UserDao().getObject(7);
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(temp);
	}
	
	@GET
	@Path("usertxtevent")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserEventTxt() throws JsonGenerationException, JsonMappingException, IOException	{
		User temp=new EventDao().getObject(50).getOrganizer();
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(temp);
	}
	
	@GET
	@Path("save")
	@Produces(MediaType.TEXT_PLAIN)
	public String saveEvent(){
		EventType eventType=new EventType("racing","bucharest tour");
		Location location=new Location("Bucharest","Romania","Piata Romana").setId(9);
		User user=new User("admin@gmail.com", "admin");

		Event event=new Event("A","Party harder",new Date(),new Date(),new Date(), 40d,user ,eventType,location);
		
		EventDao eventDao=new EventDao();
		eventDao.saveObject(event);
		return "saved";
	}
	
	
	
}
