package ro.ase.EventsPlatform.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static HibernateSessionFactory instance=null;
	private static SessionFactory factory;
	private static int counter=0;
	
	
	private HibernateSessionFactory(){
		try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		System.out.println("counter= "+counter);
	}
	
		
	public static HibernateSessionFactory getInstance(){
		System.out.println("getInstance");
		if(instance==null)
			instance=new HibernateSessionFactory();
		return instance;
	}
	
	public static SessionFactory getSessionFactory(){
		System.out.println("getSessionFactory");
		return factory;
	}
	

}
