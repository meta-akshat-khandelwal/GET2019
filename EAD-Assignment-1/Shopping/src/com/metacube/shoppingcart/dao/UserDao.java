package com.metacube.shoppingcart.dao;

import java.util.ArrayList;

import com.metacube.shoppingcart.enums.status;

import com.metacube.shoppingcart.model.User;

public class UserDao implements BaseDao<User>{


    Store s=Store.getInstance();
	
	
	ArrayList<User> userList= s.getUserList();
	
	
	@Override
	public status add(User user) {
		if(userList.add(user))
		{
			return status.SUCCESSFULL;
		}
		
		return status.NOTSUCESSFULL;
	}

	@Override
	public status delete(User user) {
		if(userList.remove(user))
			return status.SUCCESSFULL;
			
			return status.NOTSUCESSFULL;
	}

	@Override
	public status update(User user, User updateUser) {
		int index;
		index= userList.indexOf(user);
		System.out.println(index);
		userList.remove(index);
		if(userList.add(updateUser))
		return status.SUCCESSFULL;
		
		return status.NOTSUCESSFULL;
	}

	public ArrayList<User> getAllUsers()
	{
		System.out.println(userList.size());
		return userList;
	}


}
