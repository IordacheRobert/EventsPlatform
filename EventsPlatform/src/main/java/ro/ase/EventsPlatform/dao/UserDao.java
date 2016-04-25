package ro.ase.EventsPlatform.dao;

import java.util.List;

import javax.ws.rs.NotFoundException;

import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.User;

public class UserDao extends BaseDAO<User>{

	
	public UserDao() {
		super(User.class);
	}

	@Override
	public void deleteObject(int id) {

		hibernate.getSession().beginTransaction(); 
		 User temp=hibernate.getSession().get(clazz, id);
		 if(temp!=null){
			 			 
			 hibernate.getSession().delete(temp);
		 }else throw new  NotFoundException();
		 hibernate.getSession().getTransaction().commit();
	}

	@Override
	public User saveObject(User object) {
		 hibernate.getSession().beginTransaction();
		 for(Event event:object.getMyEvents()){
			 event.setOrganizer(object);
		 }
		 hibernate.getSession().saveOrUpdate(object);
		 hibernate.getSession().getTransaction().commit();
		 return object;
	}
	
	
	public List<Event> getMyEvents(int id){
		
		List<Event> myEvents=null;
		
		hibernate.getSession().beginTransaction();
		myEvents=hibernate.getSession().get(clazz, id).getMyEvents();
		hibernate.getSession().getTransaction().commit();
		
		if(myEvents.isEmpty())throw new NotFoundException();
		return myEvents;
	}

	public void addEventToUser(int parseInt, Event event) {
		// TODO Auto-generated method stub
		hibernate.getSession().beginTransaction();
		User user=hibernate.getSession().get(User.class, parseInt);
		event.setOrganizer(user);
		hibernate.getSession().save(event);
		user.getMyEvents().add(event);	
		hibernate.getSession().getTransaction().commit();
	}
	
	
	
	
}
