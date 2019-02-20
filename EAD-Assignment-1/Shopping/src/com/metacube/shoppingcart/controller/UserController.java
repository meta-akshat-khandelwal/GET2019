package com.metacube.shoppingcart.controller;

import com.metacube.shoppingcart.enums.status;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.User;

public class UserController {

	UserFacade userFacade= new UserFacade();
	
	public status addUser(User user)
	{
		if(status.SUCCESSFULL == userFacade.addUser(user))
		{
			return status.SUCCESSFULL;
		}
		else
			return status.NOTSUCESSFULL;
	}
	
	
	public status removeUser(User user)
	{
		if(status.SUCCESSFULL == userFacade.deleteUser(user))
		{
			return status.SUCCESSFULL;
		}
		else
			return status.NOTSUCESSFULL;
    }
	
	
	public status updateUser(User user, User updateUser)
	{
		if(status.SUCCESSFULL == userFacade.updateUser(user))
		{
			return status.SUCCESSFULL;
		}
		else
			return status.NOTSUCESSFULL;
	
	}
	
}
