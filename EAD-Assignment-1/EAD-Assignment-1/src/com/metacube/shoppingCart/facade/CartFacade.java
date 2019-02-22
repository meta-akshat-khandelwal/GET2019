package com.metacube.shoppingCart.facade;

import java.util.ArrayList;

import com.metacube.shoppingCart.dao.CartDao;
import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Item;
import com.metacube.shoppingCart.model.Product;

public class CartFacade {

	CartDao cartDao= new CartDao();
	ProductFacade productfacade= new ProductFacade();
	//ArrayList<Item> cart= cartDao.getCart();
	
	
	public status addItem(Item item)
	{
		ArrayList<Item> cart= cartDao.getCart();
		
		ArrayList<Product> productList= productfacade.getAllProduct();
		
		status result=null;
		for(int i=0;i<cart.size();i++)
		{
			if(item.getCode() == cart.get(i).getCode())
				result= status.DUPLICATE;
		}
		
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getCode() == item.getCode() && result!= status.DUPLICATE)
			{
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
				int productQty=productList.get(i).getQty()+item.getQty();
				productList.get(i).setQty(productQty);
				break;
			}
		}
		
		return cartDao.removeItem(id);
		
	}
	
	
	public status updateItem(Item item, int qty)
	{
		
		ArrayList<Product> productList= productfacade.getAllProduct();
		ProductFacade productFacade = new ProductFacade();
		
		Product product= productFacade.getProduct(item.getCode());
		
		
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).getCode() == item.getCode())
			{
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
	
	
	public ArrayList<Item> getCart()
	{
		return cartDao.getCart();
	}
	
	
	
	
}
