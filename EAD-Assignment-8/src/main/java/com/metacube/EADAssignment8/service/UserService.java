
package com.metacube.EADAssignment8.service;

import java.util.List;

import com.metacube.EADAssignment8.model.User;



/**
 * 
 * @author Akshat
 *
 */
public interface UserService {

		public boolean add(User employee);
		
		public boolean update(User employee);
		
		public List<User> getAll();
		
		public void delete(int id);
			
		public List<User> getUser(String type, String value);

		public User getUserByID(int id);

}
