package ro.ase.EventsPlatform.dao;

import javax.ws.rs.NotFoundException;

import ro.ase.EventsPlatform.model.User;

public class UserDao extends BaseDAO<User>{

	
	public UserDao() {
		super(User.class);
	}

	@Override
	public void deleteObject(int id) {
		// TODO Auto-generated method stub
		hibernate.getSession().beginTransaction(); 
		 User temp=hibernate.getSession().get(clazz, id);
		 if(temp!=null){
			 temp.getMyEvents().clear();
			 
			 hibernate.getSession().delete(temp);
		 }else throw new  NotFoundException();
		 hibernate.getSession().getTransaction().commit();
	}
	
	
	
	
}
