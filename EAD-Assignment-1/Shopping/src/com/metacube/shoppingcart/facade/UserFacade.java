package com.metacube.shoppingcart.facade;

import java.util.ArrayList;

import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.enums.status;
import com.metacube.shoppingcart.model.User;

public class UserFacade {
	
	 UserDao userDao= new UserDao();
	 ArrayList<User> listOfUsers=userDao.getAllUsers();
	
	public status addUser(User user)
	{
		for(int i=0;i<listOfUsers.size();i++)
		{
			
		if(listOfUsers.get(i).getId()==user.getId())
		{
			System.out.println("duplicate");
			return status.DUPLICATE;
			
		}
		}
		
			userDao.add(user);
			System.out.println("success");
			return status.SUCCESSFULL;
	}
	
	
	public status deleteUser(User user)
	{
		for(int i=0;i<listOfUsers.size();i++)
		{
			
		if(listOfUsers.get(i).getId()==user.getId())
		{
			userDao.delete(listOfUsers.get(i));
			System.out.println("deleted");
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
		
	}
	
	
	public status updateUser(User user)
	{
		for(int i=0;i<listOfUsers.size();i++)
		{
			
		if(listOfUsers.get(i).getId()==user.getId())
		{
			if(status.SUCCESSFULL==userDao.update(listOfUsers.get(i), user))
		
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
	}
	
	
	public User getUser(int id)
	{
		for(int i=0;i<listOfUsers.size();i++)
		{
			if(listOfUsers.get(i).getId() == id)
				return listOfUsers.get(i);
		}
		
		return null;
	}



	
	
	
//	public static void main(String args[])
//	{
//		User user=new User(1,"abc");
//		UserFacade facade= new UserFacade();
//		facade.addUser(user);
//		User user1=new User(1,"abc");
//		facade.addUser(user1);
//		User user2=new User(2,"xyz");
//		facade.addUser(user2);
//		User user3=new User(2,"asdf");
//		
//		facade.deleteUser(new User(1,"abc"));
//		facade.updateUser(user3);
//		UserDao userDao1= new UserDao();
//		ArrayList<User> li= userDao1.getAllUsers();
//
//		for(int i=0;i<li.size();i++)
//		{
//		
//			System.out.println(li.get(i).getName());
//		}
//	}
	

}
