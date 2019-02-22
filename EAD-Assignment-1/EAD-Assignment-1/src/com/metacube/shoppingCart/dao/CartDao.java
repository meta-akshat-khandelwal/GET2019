package com.metacube.shoppingCart.dao;

import java.util.ArrayList;

import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Cart;
import com.metacube.shoppingCart.model.Item;

public class CartDao {

	Cart cart = new Cart();
	ArrayList<Item> cartList=cart.createCart();
	
	public ArrayList<Item> getCart()
	{
		return cartList;
	}
	
	public status addItem(Item item)
	{
		try{
			cartList.add(item);
			return status.SUCCESSFULL;
		}
		catch(Exception e)
		{
		return status.ERROR;
		}
	}
	
	
	public status removeItem(int id)
	{
		for(int i=0;i<cartList.size();i++)
		{
			if(cartList.get(i).getCode() == id)
				{
				cartList.remove(i);
				return status.SUCCESSFULL;
				}
		}
		return status.NOTEXISTS;
	}
	
	
	public status updateItem(Item item, int qty)
	{
		for(int i=0;i<cartList.size();i++)
		{
			if(cartList.get(i).getCode() == item.getCode())
				{
				 Item cartItem= cartList.get(i);
				 cartItem.setQty(qty);
				return status.SUCCESSFULL;
				}
		}
		
		return status.NOTEXISTS;
	}
	
	
}
