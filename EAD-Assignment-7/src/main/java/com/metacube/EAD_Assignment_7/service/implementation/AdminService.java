
package com.metacube.EAD_Assignment_7.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EAD_Assignment_7.dao.implementation.AdminDao;
import com.metacube.EAD_Assignment_7.model.Admin;



@Service
public class AdminService {

	
	@Autowired
	AdminDao adminDao;
	/**
	 * 
	 * @param id
	 * @param password
	 * @return boolean value if admin has correct password, else false
	 */
	public boolean getAdmin(String id, String password)
	{
		try{
		Admin admin = adminDao.getAdminById(id);
		
		if(password.equals(admin.getPassword()) && admin!=null)
				return true;

		
		return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
