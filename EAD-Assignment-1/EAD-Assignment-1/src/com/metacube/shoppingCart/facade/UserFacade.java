package com.metacube.shoppingCart.facade;

import com.metacube.shoppingCart.dao.UserDao;
import com.metacube.shoppingCart.model.User;

public class UserFacade {

	UserDao userDao= new UserDao();
	
	public User getUser(int id, String name)
	{
		return userDao.createUser(id, name);
	}
	
}
