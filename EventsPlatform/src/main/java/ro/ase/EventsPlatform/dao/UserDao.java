package ro.ase.EventsPlatform.dao;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;

import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.User;

public class UserDao extends BaseDAO<User>{

	
	public UserDao() {
		super(User.class);
	}

	public User getUserByEmailAndPassword(String email, String password){
		User user=null;
		
		hibernate.getSession().beginTransaction(); 
		Criteria criteria=hibernate.getSession().createCriteria(User.class);
		
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List list=criteria.list();
		
		if(list.isEmpty())throw new  NotFoundException();
		else user=(User) list.get(0);
		
		hibernate.getSession().getTransaction().commit();
		
		return user;
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
