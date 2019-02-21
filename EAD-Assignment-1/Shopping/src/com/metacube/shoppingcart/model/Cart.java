
package com.metacube.shoppingcart.model;

import java.util.ArrayList;

public class Cart {
	
	ArrayList<Item> cart= new ArrayList<Item>();
	
	public ArrayList<Item> getAllItem()
	{
		return cart;
	}
	
	
	public Item getItemByCode(int code)
	{
		for(int i=0;i<cart.size();i++)
		{
			if(cart.get(i).getCode() == code)
				return cart.get(i);
		}
		
		return null;
	}


	public void addItem(Item item1) {
		cart.add(item1);
		
	}
	

}
