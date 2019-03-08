
package com.metacube.EADAssignment8.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADAssignment8.model.User;
import com.metacube.EADAssignment8.repository.UserRepository;
import com.metacube.EADAssignment8.service.UserService;



/**
 * It provides service to the controller 
 * @author Akshat
 *
 */

@Service
public class UserServiceImplementation implements UserService {


	@Autowired
	UserRepository<User> userRepository;
	
	/*
	 * Adds User
	 * @param, user
	 * @return, true if sucessfull false otherwise
	 */
	@Transactional
	public boolean add(User user) 
	{
		return userRepository.save(user)!=null;
	}

	/*
	 *updates user
	 *@param, user
	 *@return,   true if sucessfull false otherwise
	 */
	@Transactional
	public boolean update(User user)
	{
		return userRepository.save(user)!=null;
	}

	/*
	 *list of all users
	 *@return list of all users 
	 */
	@Transactional
	public List<User> getAll() 
	{
		return (List<User>)userRepository.findAll();
	}

	/*
	 *deletes User
	 *@param, id of user
	 *@return,  true if sucessfull false otherwise
	 */
	@Transactional
	public void delete(int id)
	{
		 userRepository.delete(id);
	}

	
	/*
	 *Searches user 
	 *@param, type name,email,etc
	 *@param, name of user, email of user, etc
	 *@return list of all users matches the parameter   
	 */
	@Transactional
	public List<User> getUser(String type, String value) {
		if(type.equals("email"))
		return (List<User>)userRepository.findByEmail(value);
		
		if(type.equals("first_name"))
			return (List<User>)userRepository.findByFirstName(value);	
		
		if(type.equals("last_name"))
			return (List<User>)userRepository.findByLastName(value);	
		
		if(type.equals("contact_number"))
			return (List<User>)userRepository.findByContactNumber(value);	
			
		return null;
	}

	/*
	 *get user by its id
	 *@param, id of user
	 *@return, User 
	 */
	@Override
	public User getUserByID(int id)
	{
		List<User> user = (List<User>)userRepository.findById(id);
		return user.get(0);
	}
	

	
	

}
