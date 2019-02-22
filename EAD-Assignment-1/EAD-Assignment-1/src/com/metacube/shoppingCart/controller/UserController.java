package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.facade.UserFacade;
import com.metacube.shoppingCart.model.User;

public class UserController {

	UserFacade userFacade= new UserFacade();
	
	public User createUser(int id, String name)
	{
		if(id<=0 || name==null)
			return null;
		else
			return userFacade.getUser(id,name);
		
	}
	
	
}
