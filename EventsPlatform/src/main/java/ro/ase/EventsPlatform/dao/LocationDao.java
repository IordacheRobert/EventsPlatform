package ro.ase.EventsPlatform.dao;

import org.hibernate.Session;

import ro.ase.EventsPlatform.model.Location;
import ro.ase.EventsPlatform.utils.HibernateUtils;

public class LocationDao{

//	public LocationDao() {
//		super(Location.class);
//		// TODO Auto-generated constructor stub
//	}

	
	
	private HibernateUtils utils=HibernateUtils.getInstance();
	
	public Location getLocation(int id){
		Location temp=null;
	
		utils.getSession().beginTransaction();
		temp=utils.getSession().get(Location.class, id);
		utils.getSession().getTransaction().commit();
	
		return temp;
	}

	
	
	
	
}
