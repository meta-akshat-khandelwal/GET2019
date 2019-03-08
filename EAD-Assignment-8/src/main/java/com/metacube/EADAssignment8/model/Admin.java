package com.metacube.EADAssignment8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin with its attributes
 * @author Akshat
 *
 */

@Entity
@Table(name= "admin")
public class Admin {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name= "password")
	private String password;
	
	
	public void setId(String id) {
		this.id = id;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getId() {
		return id;
	}


	public String getPassword() {
		return password;
	}

	
	public Admin() {}

	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
