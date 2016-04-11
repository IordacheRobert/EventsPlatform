package ro.ase.EventsPlatform.rest;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import ro.ase.EventsPlatform.dao.EventDao;
import ro.ase.EventsPlatform.dao.LocationDao;
import ro.ase.EventsPlatform.dao.UserDao;
import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.Location;
import ro.ase.EventsPlatform.model.User;



@Path("res")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Robert did it and works! :)";
    }
    
    
    @GET
    @Path("event")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEvent(){
    	
    	Event temp=new EventDao().getEvent(25);
    	return temp;
		
    }
    
    @GET
    @Path("location")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocation(){
    	return new LocationDao().getObject(11);
		
    }
    

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
    	return new UserDao().getObject(3);
		
    }
    
    
//    @GET
//    @Path("/images/{name}")
//    @Produces("image/jpg")
//    public Response downloadImageFile(@PathParam("name")String denumire) {
//    	ClassLoader classLoader = getClass().getClassLoader();
//        // set file (and path) to be download
//    	String path=null;
//    	try{
//    		 path=classLoader.getResource("im ages/"+denumire).getFile();
//    		 path=URLDecoder.decode(path,"UTF-8");
//    	}catch(NullPointerException ex){
//    		System.out.println(ex.getMessage());
//    		 return Response.ok().status(404).build();
//    	} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(path);
//        File file = new File(path);
// 
//        ResponseBuilder responseBuilder = Response.ok((Object) file);
//       // responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
//        return responseBuilder.build();
//    }
    
    
}
