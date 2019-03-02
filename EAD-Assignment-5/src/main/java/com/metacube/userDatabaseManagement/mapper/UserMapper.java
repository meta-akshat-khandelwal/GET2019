package com.metacube.userDatabaseManagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.userDatabaseManagement.model.User;
/**
 * Maps the data extracted from database to user object
 * @author Akshat
 *
 */
public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int i) throws SQLException {
		
		User user =new User();
		user.setId(rs.getInt(1));
		user.setFirst_name(rs.getString(2));
		user.setLast_name(rs.getString(3));
		user.setContact_number(rs.getString(4));
		user.setEmail(rs.getString(5));
		return user;	
	}
}
