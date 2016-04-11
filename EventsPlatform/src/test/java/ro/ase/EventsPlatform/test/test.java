package ro.ase.EventsPlatform.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;

import ro.ase.EventsPlatform.dao.EventDao;
import ro.ase.EventsPlatform.dao.EventTypeDao;
import ro.ase.EventsPlatform.dao.LocationDao;
import ro.ase.EventsPlatform.dao.UserDao;
import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.EventType;
import ro.ase.EventsPlatform.model.Location;
import ro.ase.EventsPlatform.model.User;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HibernateSessionFactory hibernateSessionFactory=HibernateSessionFactory.getInstance();
//		hibernateSessionFactory.getSessionFactory();
//		hibernateSessionFactory.getSessionFactory();
//		hibernateSessionFactory.getSessionFactory();
//		hibernateSessionFactory.getSessionFactory();
//	
//		
//		HibernateSessionFactory hibernateSessionFactory2=HibernateSessionFactory.getInstance();
//		hibernateSessionFactory2.getSessionFactory();
//		hibernateSessionFactory2.getSessionFactory();
//		hibernateSessionFactory2.getSessionFactory();
//		hibernateSessionFactory2.getSessionFactory();
		
		Location location=new Location("Bucharest","Romania","Piata Romana").setId(9);
		System.out.println(location);
		
		User user=new User("admin@gmail.com", "admin");
		User user2=new User("user2@gmail.com", "admin");
		User user3=new User("user3@gmail.com", "admin");
		System.out.println(user);
		EventType eventType=new EventType("racing","bucharest tour");
		
		Event event=new Event("A","Party harder",new Date(),new Date(),new Date(), 40d,user ,eventType,location);
		
		Event event2=new Event("B","Party harder",new Date(),new Date(),new Date(), 40d,user ,eventType,location);

		Event event3=new Event("C","Party harder",new Date(),new Date(),new Date(), 40d,user ,eventType,location);
		
		
		LocationDao locationDao=new LocationDao();
		EventTypeDao eventTypeDao=new EventTypeDao();
		UserDao userDao=new UserDao();
		EventDao eventDao=new EventDao();
		
		//event.addParticipant(user2);
		//event.addParticipant(user3);
		
		//eventDao.saveObject(event);
		//Event temp=eventDao.getEvent(25);
		//System.out.println(temp.getParticipants());
		//System.out.println(temp.getParticipants().size());
		//System.out.println(event);
		//System.out.println("-------------------------");
		//Event temp=eventDao.getObject(1);
		//System.out.println(temp.toString());
		//userDao.saveObject(user);
		//eventDao.saveObject(event);
//		Event temp=eventDao.getObject(1);
//		//System.out.println(eventDao.getObject(1).getParticipants().size());
//		Iterator<User> it=temp.getParticipants().iterator();
//		System.out.println(temp.getOrganizer().getEmail());
//		while (it.hasNext()) {
//		    System.out.println(it.next().getEmail());
//		}
		
		
		
		//user.getEvents().add(event);
		//userDao.saveObject(user);
		//locationDao.saveObject(location);
		//locationDao.deleteObject(location);
//		try{
//			System.out.println(locationDao.getObject(8).toString());
//		}catch(Exception ex){
//			System.out.println(ex.getMessage());
//		}
//		
//		locationDao.updateObject(location.setId(55).setCity("titu"));
		
		
		
		
	}

}
