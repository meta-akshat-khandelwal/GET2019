package com.metacube.shoppingcart.model;



public class User {
	
	private int id;
	private String name;
	Cart cart = new Cart();
	
	public User(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	
	public Cart getCart() {
		return cart;
	}


	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	

}
