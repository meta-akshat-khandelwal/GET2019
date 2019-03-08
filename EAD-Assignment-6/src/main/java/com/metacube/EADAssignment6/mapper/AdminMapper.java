package com.metacube.EADAssignment6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADAssignment6.model.Admin;

/**
 * Maps the data extracted from database to user object
 * @author Akshat
 *
 */
public class AdminMapper implements RowMapper<Admin>
{
public Admin mapRow(ResultSet rs, int i) throws SQLException
{
		
		Admin admin =new Admin(rs.getString(1),rs.getString(2));

		return admin;	
	}
}
