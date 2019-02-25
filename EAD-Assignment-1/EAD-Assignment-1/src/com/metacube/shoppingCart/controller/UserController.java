package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.facade.UserFacade;
import com.metacube.shoppingCart.model.User;
/**
 * creates the user with name and id
 * @author Akshat
 *
 */
public class UserController {

	UserFacade userFacade= new UserFacade();
	/*
	 * creates the user 
	 * @param, id of user
	 * @param, name of user
	 * @returns User object
	 */
	public User createUser(int id, String name)
	{
		if(id<=0 || name==null)
			return null;
		else
			return userFacade.getUser(id,name);
		
	}
	
	
}
