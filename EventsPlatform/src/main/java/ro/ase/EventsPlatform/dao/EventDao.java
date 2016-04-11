package ro.ase.EventsPlatform.dao;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import ro.ase.EventsPlatform.model.Event;


public class EventDao extends BaseDAO<Event> {

	public EventDao() {
		super(Event.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public Event getEvent(int id){
		Event temp = null;
		openSession();
		 
		 Transaction transaction=null;
		 try{
			 transaction=this.session.beginTransaction();
			 temp=this.session.get(Event.class, id);
			 //temp.setParticipants(temp.getParticipants());
			// Hibernate.initialize(temp.getParticipants());
			 
			// System.out.println("Id="+id);
			 System.out.println(temp.getParticipants());
			 transaction.commit();
		 }catch(HibernateException ex){
			 if(transaction!=null)
				 transaction.rollback();
		 }finally{
			 closeSession();
		 }
		return temp;
	}

}
