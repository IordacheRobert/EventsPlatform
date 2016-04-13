package ro.ase.EventsPlatform.dao;

import java.util.List;

import javax.ws.rs.NotFoundException;
import org.hibernate.Session;
import ro.ase.EventsPlatform.utils.HibernateSessionFactory;
import ro.ase.EventsPlatform.utils.HibernateUtils;


public class BaseDAO <T>{
	
	 HibernateSessionFactory factory;
	 protected Session session;
	 protected Class<T> clazz;
	 protected HibernateUtils hibernate;
	 
	 public BaseDAO(Class<T> clazz) {
		super();
		this.hibernate=HibernateUtils.getInstance();
		this.clazz = clazz;
	}
	 
	 public T saveObject(T object){
		 hibernate.getSession().beginTransaction();
		 hibernate.getSession().saveOrUpdate(object);
		 hibernate.getSession().getTransaction().commit();
		 return object;
	 }
	 
	 public T updateObject(T object){
		 hibernate.getSession().beginTransaction();
		 hibernate.getSession().update(object);
		 hibernate.getSession().getTransaction().commit();
		return object;
	 }
	 
	 public void deleteObject(int id){
		 hibernate.getSession().beginTransaction(); 
		 T temp=hibernate.getSession().get(clazz, id);
		 if(temp!=null){
			 hibernate.getSession().delete(temp);
		 }else throw new  NotFoundException();
		 hibernate.getSession().getTransaction().commit();
	 }
	 
	 public T getObject(int id){
		 T temp = null;
		 hibernate.getSession().beginTransaction();
		 temp=hibernate.getSession().get(clazz, id);
		 hibernate.getSession().getTransaction().commit();
		 
		 if(temp==null)throw new NotFoundException();
		return temp;
	 }
	 
	 public List<T> getAll(){
		 List<T> list = null;
		 
		 hibernate.getSession().beginTransaction();
		 list=hibernate.getSession().createCriteria(clazz).list();
		 hibernate.getSession().getTransaction().commit();
		 
		 if(list.isEmpty())throw new NotFoundException();
		 
		 return list;
	 }
}
