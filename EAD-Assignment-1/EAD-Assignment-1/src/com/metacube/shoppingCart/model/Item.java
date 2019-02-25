package com.metacube.shoppingCart.model;
/**
 * Creates Item with some attributes like
 * code
 * name
 * type
 * price
 * Quantity
 * @author Akshat
 *
 */
public class Item {
	private int code;
	private String name;
	private String type;
	private int price;
	private int qty;
	
	public Item(int code, String name, String type, int price, int qty) {
		
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.qty = qty;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public int getQty() {
		return qty;
	}
	
	
	
	
}
