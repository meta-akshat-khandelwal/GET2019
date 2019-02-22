package com.metacube.shoppingCart.model;

public class Product {
	private int code;
	private String name;
	private String type;
	private int price;
	private int qty;
	
	
	public Product(int code, String name, String type, int price, int qty) {
		
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.qty = qty;
		
	}

	public int getQty() {
		return qty;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getPrice() {
		return price;
	}
	
	public void setQty(int qty)
	{
		this.qty= qty;
	}
	
}
