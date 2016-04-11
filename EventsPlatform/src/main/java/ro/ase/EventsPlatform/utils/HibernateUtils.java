package ro.ase.EventsPlatform.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {

	private static HibernateUtils instance = null;
	private static SessionFactory factory;
	private static Session session;
	
	
	private static int count=0;
	

	private HibernateUtils() {
		System.out.println("count="+(count++));
		try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}

	public static HibernateUtils getInstance() {
		
		if (instance == null)
			instance = new HibernateUtils();
		return instance;
	}
	
	
	public SessionFactory getFactory(){
		return factory;
	}
	
	public void openSession() {
		session = factory.openSession();
	}
	
	
	public void closeSession() {
		if(session.isOpen())session.close();
	}
	
	public Session getSession(){
		return session;
	}

}
