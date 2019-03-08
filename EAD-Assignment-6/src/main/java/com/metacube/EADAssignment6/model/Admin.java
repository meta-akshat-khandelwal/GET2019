package com.metacube.EADAssignment6.model;
/**
 * Admin with its attributes
 * @author Akshat
 *
 */
public class Admin {
	private String id;
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


	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
