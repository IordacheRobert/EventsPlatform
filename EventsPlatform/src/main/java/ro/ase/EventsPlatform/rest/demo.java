package ro.ase.EventsPlatform.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ro.ase.EventsPlatform.dao.LocationDao;
import ro.ase.EventsPlatform.model.Location;


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
		return new LocationDao().getLocation(11);
	}
	
}
