package com.metacube.shoppingCart.facade;

import com.metacube.shoppingCart.dao.UserDao;
import com.metacube.shoppingCart.model.User;
/**
 * Creates the user
 * @author Akshat
 *
 */
public class UserFacade {

	UserDao userDao= new UserDao();
	
	/*
	 * creates the user
	 * @param, id of user
	 * @param, name of user
	 * @returns User
	 */
	public User getUser(int id, String name)
	{
		return userDao.createUser(id, name);
	}
	
}
