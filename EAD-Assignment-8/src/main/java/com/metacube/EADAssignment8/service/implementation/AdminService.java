
package com.metacube.EADAssignment8.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADAssignment8.model.Admin;
import com.metacube.EADAssignment8.repository.AdminRepository;



@Service
public class AdminService {

	
	@Autowired
	AdminRepository adminRepository;
	/**
	 * 
	 * @param id
	 * @param password
	 * @return boolean value if admin has correct password, else false
	 */
	public boolean getAdmin(String id, String password)
	{
		try{
		Admin admin = adminRepository.findById(id);
		
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
