package com.metacube.shoppingCart.dao;

import java.util.ArrayList;

import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Cart;
import com.metacube.shoppingCart.model.Item;
/**
 * performs the following task:
 * 1. Add the Item to cart
 * 2. removes the Item from cart
 * 3. updates the Item in cart
 * 4. Return Cart
 * @author Akshat
 *
 */
public class CartDao {

	Cart cart = new Cart();
	ArrayList<Item> cartList=cart.createCart();
	
	/*
	 *Get all item in cart
	 * @return list of item in cart
	 */
	public ArrayList<Item> getCart()
	{
		return cartList;
	}
	
	/*
	 * Adds the Item to cart
	 * @param, Item to be added
	 * @return status
	 */
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
	
	/*
	 * removes the item from cart
	 * @param, id of item
	 * @return status
	 */
	
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
	
	/*
	 * Update Items in cart
	 * @param, Item to be updated
	 * @param, Quantity of item
	 * @returns status
	 */
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
