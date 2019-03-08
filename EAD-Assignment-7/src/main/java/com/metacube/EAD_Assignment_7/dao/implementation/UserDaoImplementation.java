package com.metacube.EAD_Assignment_7.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_7.dao.UserDao;
import com.metacube.EAD_Assignment_7.model.User;


@Repository
@Transactional
public class UserDaoImplementation implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	/*
	 * Adds User
	 * @param, user
	 * @return, true if sucessfull false otherwise
	 */
	public boolean addUser(User user) 
	{
		Session current = sessionFactory.getCurrentSession();
		try{
			current.save(user);
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
  
	
	/*
	 *deletes User
	 *@param, user
	 *@return,  true if sucessfull false otherwise
	 */
	public boolean deleteUser(User user)
	{
	
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	/*
	 *updates user
	 *@param, user
	 *@return,   true if sucessfull false otherwise
	 */
	public boolean updateUser(User user)
	{
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	
	
	/*
	 *list of all users
	 *@return list of all users 
	 */
	public List<User> getAllUser()
	{
		Session session = sessionFactory.getCurrentSession();	
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> results = query.list();
		return results;
	}
	

	/*
	 *Searches user 
	 *@param, type name,email,etc
	 *@param, name of user, email of user, etc
	 *@return list of all users matches the parameter   
	 */
	public List<User> getUser(String type, String value) 
	{
		Session session = sessionFactory.getCurrentSession();	
		String hql = "FROM User user WHERE user."+type+" ="+"'"+value+"'";
		Query query = session.createQuery(hql);
		List<User> results = query.list();
		return results;
		
	}
	
}
