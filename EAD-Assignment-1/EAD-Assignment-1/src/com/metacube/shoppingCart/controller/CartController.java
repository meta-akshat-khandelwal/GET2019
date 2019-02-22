package com.metacube.shoppingCart.controller;

import java.util.ArrayList;

import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.facade.CartFacade;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.model.Item;
import com.metacube.shoppingCart.model.Product;

public class CartController {
	
	CartFacade cartFacade= new CartFacade();
	ProductFacade productFacade= new ProductFacade();
	
	public status addItem(int id, int qty)
	{   
		    if(qty<=0)
		    	return status.NOTAVAILABLE;
		    
		    
			Product product=  productFacade.getProduct(id);
			Item item= new Item(product.getCode(),product.getName(),
		            product.getType(),product.getPrice(),qty);
			
			if(qty> product.getQty())
				return status.NOTAVAILABLE;
			
			if(product!= null  && qty> product.getQty())
			{
				
				return cartFacade.addItem(item);
			
			
		
			}
			
			return cartFacade.addItem(item);
	}
	
	public status removeItem(int id)
	{
		ArrayList<Item> cartList= cartFacade.getCart();
		for(int i=0;i<cartList.size();i++)
		{
			if(cartList.get(i).getCode() == id )
				 return cartFacade.removeItem(id);
				
		}
		
		return status.NOTSUCESSFULL;
	 
	}
	
	
	
	public status updateItem(int id , int qty)
	{  
		if(qty<=0)
	    	return status.NOTAVAILABLE;
		
		ArrayList<Item> cartList= cartFacade.getCart();
		Item item= null;
		Product product=  productFacade.getProduct(id);
		if(product!= null  && qty< product.getQty())
		{
			for(int i=0;i<cartList.size();i++)
			{
				if(cartList.get(i).getCode() == id)
				{
					item=cartList.get(i);
					break;
				}
					
			}
			if(item!= null)
				return cartFacade.updateItem(item,qty);
	
			else
				return status.NOTSUCESSFULL;
		}
		
		return status.NOTSUCESSFULL;
	}	
	
	public ArrayList<Item> getCart()
	{
		return cartFacade.getCart();
	}
	
	

}
