package com.metacube.EADAssignment6.dao.implementation;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.EADAssignment6.dao.Query;
import com.metacube.EADAssignment6.mapper.AdminMapper;
import com.metacube.EADAssignment6.model.Admin;
/**
 * 
 * @author Akshat
 *
 */

@Repository
public class AdminDao {

	private JdbcTemplate jdbcTemplate;
	
	public AdminDao(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/**
	 * get all admins
	 * @param id
	 * @return list of admins corresponding to id
	 */
	public List<Admin> getAdmins(String id)
	{
		return jdbcTemplate.query(Query.getAdmin+" = '"+id+"'",new AdminMapper());
	} 
	
	
}
