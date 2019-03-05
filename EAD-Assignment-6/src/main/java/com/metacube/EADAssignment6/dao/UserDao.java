package com.metacube.EADAssignment6.dao;

import java.util.List;

import com.metacube.EADAssignment6.model.User;
/**
 * @author Akshat
 */
public interface UserDao {

	
	public boolean addUser(User user);
	
	public boolean deleteUser(int id);
	
	public boolean updateUser(User user);
	
	public List<User> getAllUser();
	
	public List<User> getUser(String type, String value);
}