package com.metacube.EAD_Assignment_7.dao.implementation;


import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Assignment_7.model.Admin;



@Repository
@Transactional
public class AdminDao {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * get  admin
	 * @param id
	 * @return  admin corresponding to id
	 */
	public Admin getAdminById(String id)
	{	
		Admin admins=null;
		try{
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Admin admin WHERE admin.id = "+id;
		Query query = session.createQuery(hql);
		List<Admin> results = query.list();
		 
		admins=results.get(0);
		
		return admins;
		}
		catch(Exception e)
		{
			return null;
		}
	} 
	
}
