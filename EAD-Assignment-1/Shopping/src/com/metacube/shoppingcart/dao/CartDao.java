package com.metacube.shoppingcart.dao;

import java.util.ArrayList;


import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.User;

public class CartDao {
	
	Store store = Store.getInstance();
	
	UserDao userDao = new UserDao();
	
	 ArrayList<User> userList = userDao.getAllUsers();
	
	
	public Cart getCart(int userId)
	{
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).getId() == userId)
			{
				Cart cart = userList.get(i).getCart();
				return cart;
			}
		}
		return null;
	}
}
