package com.metacube.userDatabaseManagement.dao.implementation;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.userDatabaseManagement.dao.Query;
import com.metacube.userDatabaseManagement.dao.UserDao;
import com.metacube.userDatabaseManagement.mapper.UserMapper;
import com.metacube.userDatabaseManagement.model.User;
/**
 *It implements the interface Userdao
 *  which contains some method to perform some operations
 * @author Akshat
 *
 */

@Repository
public class UserDaoImplementation  implements UserDao  {

	
private JdbcTemplate jdbcTemplate;
	
	
	public UserDaoImplementation(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * Adds User
	 * @param, user
	 * @return, true if sucessfull false otherwise
	 */
	public boolean addUser(User user)
	{
		return jdbcTemplate.update(Query.insertUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail()) > 0;
	}

	/*
	 *deletes User
	 *@param, id of user
	 *@return,  true if sucessfull false otherwise
	 */
	public boolean deleteUser(int id) 
	{
		return jdbcTemplate.update(Query.deleteUser, id) > 0;
	}

	/*
	 *updates user
	 *@param, user
	 *@return,   true if sucessfull false otherwise
	 */
	public boolean updateUser(User user) 
	{
		return jdbcTemplate.update(Query.updateUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail(), user.getId()) > 0;
	}
	
	
	/*
	 *list of all users
	 *@return list of all users 
	 */
	public List<User> getAllUser()
	{
		return jdbcTemplate.query(Query.getAllUser, new UserMapper());
	}
	
	
	/*
	 * get user by id
	 * @param, id
	 * @return User, else null
	 */
	public User getUserByID(int id)
	{
		List<User> userList = getAllUser();
		for(User u : userList)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}
	
	/*
	 *Searches user 
	 *@param, type name,email,etc
	 *@param, name of user, email of user, etc
	 *@return list of all users matches the parameter   
	 */
	public List<User> getUser(String type,String value)
	{
		return jdbcTemplate.query(Query.getUser+" "+type+" = '"+value+"'",new UserMapper());
	} 
}
