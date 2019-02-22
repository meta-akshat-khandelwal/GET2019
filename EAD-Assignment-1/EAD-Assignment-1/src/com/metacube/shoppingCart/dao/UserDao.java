package com.metacube.shoppingCart.dao;

import com.metacube.shoppingCart.model.User;

public class UserDao {

	public User createUser(int id, String name)
	{
		User user = new User(id, name);
		
		return user;
	}
	
	
}
