package com.metacube.EAD_Assignment_7.dao;

import java.util.List;

import com.metacube.EAD_Assignment_7.model.User;



public interface UserDao {
	
	public boolean addUser(User user);
	
	public boolean deleteUser(User user);
	
	public boolean updateUser(User user);
	
	public List<User> getAllUser();
	
	public List<User> getUser(String type, String value);
}
