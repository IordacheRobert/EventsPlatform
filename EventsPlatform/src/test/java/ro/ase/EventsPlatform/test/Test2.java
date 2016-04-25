package ro.ase.EventsPlatform.test;


import java.util.ArrayList;
import java.util.List;

import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.model.User;
import ro.ase.EventsPlatform.utils.HibernateUtils;

public class Test2 {
	public static void main(String[] args){
	
		HibernateUtils util=HibernateUtils.getInstance();
		util.openSession();
		util.getSession().beginTransaction();
		User temp=null;
		User user=new  User("participant.com", "password");
		temp=util.getSession().get(User.class, 14);
		Event event=util.getSession().get(Event.class, 75);
		
		//event.removeParticipant(event.getParticipants().get(0));
		//event.getParticipants().get(0).getAttendedEvents().remove(event);
		
		util.getSession().getTransaction().commit();
		util.closeSession();
		
	}
}
