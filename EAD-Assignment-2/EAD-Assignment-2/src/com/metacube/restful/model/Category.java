package com.metacube.restful.model;
/**
 * 
 * @author Akshat
 *
 */
public class Category {

	private int id;
	private String name;
	
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}