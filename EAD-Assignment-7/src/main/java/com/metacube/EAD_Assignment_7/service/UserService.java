
package com.metacube.EAD_Assignment_7.service;

import java.util.List;

import com.metacube.EAD_Assignment_7.model.User;



/**
 * 
 * @author Akshat
 *
 */
public interface UserService {

		public boolean add(User employee);
		
		public boolean update(User employee);
		
		public List<User> getAll();
		
		public boolean delete(int id);
		
		public User getUserByID(int id);
			
		public List<User> getUser(String type, String value);

}
