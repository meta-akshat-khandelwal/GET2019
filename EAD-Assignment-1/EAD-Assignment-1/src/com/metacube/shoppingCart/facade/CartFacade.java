package com.metacube.shoppingCart.facade;
/**
 * performs the following task:
 * 1. Add the Item to cart
 * 2. removes the Item from cart
 * 3. updates the Item in cart
 * 4. Return Cart
 * @author Akshat
 *
 */
import java.util.ArrayList;

import com.metacube.shoppingCart.dao.CartDao;
import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Item;
import com.metacube.shoppingCart.model.Product;

public class CartFacade {

	CartDao cartDao= new CartDao();
	ProductFacade productfacade= new ProductFacade();
	
	/*
	 * Adds item in cart
	 * @param ,item
	 * @returns status
	 */
	public status addItem(Item item)
	{
		ArrayList<Item> cart= cartDao.getCart();
		
		ArrayList<Product> productList= productfacade.getAllProduct();
		
		status result=null;
		for(int i=0;i<cart.size();i++)
		{   
			// checks if duplicate product is available or not
			if(item.getCode() == cart.get(i).getCode())
				result= status.DUPLICATE;
		}
		
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getCode() == item.getCode() && result!= status.DUPLICATE)
			{
				// set the quantity of product in store 
				int qtyValue= productList.get(i).getQty()-item.getQty();
				productList.get(i).setQty(qtyValue);
			}
		}
		
		if(result == null)
		{
		cartDao.addItem(item);
		result= status.SUCCESSFULL;
		}
		
		
		return result;
		
	}
	
	/*
	 * Removes the item from cart
	 * @param, id of item
	 * @returns status
	 */
	public status removeItem(int id)
	{
		ArrayList<Product> productList= productfacade.getAllProduct();
		ArrayList<Item> cart= cartDao.getCart();
		Item item=null;
		for(int i=0;i<cart.size();i++)
		{
			if(cart.get(i).getCode() == id)
			{
				item = cart.get(i);
				break;
			}
		}
		
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getCode() == id)
			{
				// adds the quantity of item to product in store
				int productQty=productList.get(i).getQty()+item.getQty();
				productList.get(i).setQty(productQty);
				break;
			}
		}
		
		return cartDao.removeItem(id);
		
	}
	
	/*
	 * updates quantity of item in cart
	 * @param Item
	 * @param, quantity
	 * @param status
	 */
	public status updateItem(Item item, int qty)
	{
		
		ArrayList<Product> productList= productfacade.getAllProduct();
		ProductFacade productFacade = new ProductFacade();
		
		Product product= productFacade.getProduct(item.getCode());
		
	
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getCode() == item.getCode())
			{
				//updates the quantity of product in store
				if(item.getQty()>qty)
				{
					
				int qtyValue= productList.get(i).getQty()+(item.getQty()-qty);
				productList.get(i).setQty(qtyValue);
				}
				
				if(item.getQty()<qty)
				{
					int qtyValue= productList.get(i).getQty()-(qty-item.getQty());
					productList.get(i).setQty(qtyValue);
				}
			}
		}
		
		if(product != null && product.getQty()>qty)
		{
			if(cartDao.updateItem(item, qty) == status.SUCCESSFULL)
			{
			 return status.SUCCESSFULL;	
			}
		}
		
		     return	status.NOTSUCESSFULL;
		
	}
	
	/*
	 * all items of cart
	 * @returns list of items in cart
	 */
	public ArrayList<Item> getCart()
	{
		return cartDao.getCart();
	}
	
	
	
	
}
