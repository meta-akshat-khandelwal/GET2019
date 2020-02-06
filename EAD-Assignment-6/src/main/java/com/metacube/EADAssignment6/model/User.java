
package com.metacube.EADAssignment6.model;
/**
 * User with basic details like
 * id
 * First Name
 * Last Name
 * Contact Number
 * E-Mail
 * @author Akshat
 *
 */
public class User {

	private int id;
	private String first_name;
	private String last_name;
	private String contact_number;
	private String email;

	public int getId() {
		return id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getContact_number() {
		return contact_number;
	}


	public String getEmail() {
		return email;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
