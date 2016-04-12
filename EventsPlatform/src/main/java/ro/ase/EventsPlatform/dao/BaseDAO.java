package ro.ase.EventsPlatform.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ro.ase.EventsPlatform.model.Event;
import ro.ase.EventsPlatform.utils.HibernateSessionFactory;
import ro.ase.EventsPlatform.utils.HibernateUtils;


public class BaseDAO <T>{
	
	 HibernateSessionFactory factory;
	 protected Session session;
	 private Class<T> clazz;
	 private HibernateUtils hibernate;
	 
	 public BaseDAO(Class<T> clazz) {
		super();
		this.hibernate=HibernateUtils.getInstance();
		this.clazz = clazz;
	}

	 
	 public void saveObject(T object){
		 hibernate.getSession().beginTransaction();
		 hibernate.getSession().save(object);
		 hibernate.getSession().getTransaction().commit();
	 }
	 
	 public void updateObject(T object){
		 hibernate.getSession().beginTransaction();
		 hibernate.getSession().update(object);
		 hibernate.getSession().getTransaction().commit();
		
	 }
	 
	 public void deleteObject(T object){
		 hibernate.getSession().beginTransaction();
		 hibernate.getSession().delete(object);
		 hibernate.getSession().getTransaction().commit();
	 }
	 
	 public T getObject(int id){
		 T temp = null;
		 hibernate.getSession().beginTransaction();
		 temp=hibernate.getSession().get(clazz, id);
		 hibernate.getSession().getTransaction().commit();
		 
		 if(temp==null)throw new HibernateException("The instance of "+clazz.getSimpleName()+" that you want to access doesn't exist.");
		return temp;
	 }
	 
}
