package com.metacube.shoppingCart.dao;

import com.metacube.shoppingCart.model.User;
/**
 * Creates the user
 * @author Akshat
 *
 */
public class UserDao {

	/*
	 * creates the user
	 * @param, id of user
	 * @param, name of user
	 * @returns User
	 */
	public User createUser(int id, String name)
	{
		User user = new User(id, name);
		
		return user;
	}
	
	
}
