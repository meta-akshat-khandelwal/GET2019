package com.metacube.shoppingcart.facade;

import java.util.ArrayList;

import com.metacube.shoppingcart.dao.CartDao;
import com.metacube.shoppingcart.enums.status;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Item;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class CartFacade {
	

	CartDao cartDao = new CartDao();
	
	public status addItemToCart(int userId, Product product, int qty)
	{
		Cart cart = cartDao.getCart(userId);
		if(cart!=null)
		{
			Item item = cart.getItemByCode(product.getCode());
			if(item!=null)
			{
				int totalQty=item.getQty()+qty;
				if(totalQty<product.getQty())
				{
				item.setQty(totalQty);
				return status.SUCCESSFULL;
				}
				else
					return status.NOTAVAILABLE;
			}
			else
			{
				Item item1= new Item(product.getCode(),product.getName(),product.getType(),product.getPrice(),qty);
				cart.addItem(item1);
				return status.SUCCESSFULL;
			}
		}
		else 
		{
			return status.NOTEXISTS;
		}
		
	}
	
	public status deleteProductFromCart(int userId, Product product)
	{
		Cart cart = cartDao.getCart(userId);
		Item item = cart.getItemByCode(product.getCode());
		if(item!=null)
		{
			if(item.getQty() == product.getProduct_qty())
			{
				 cart.removeProduct(pro);
				 return status.SUCCESSFULL;
			}
			else if(pro.getProduct_qty() > product.getProduct_qty())
			{
				pro.setProduct_qty(pro.getProduct_qty() - product.getProduct_qty());
				return status.SUCCESSFULL;
			}
			else
			{
				return status.NOTSUCESSFULL;
			}	
		}
		return status.NOTEXISTS;
	}
	
	public ArrayList<Product> getCartList(int user_id)
	{
		Cart cart = cartDao.getCart(user_id);
		if(cart!=null)
		{
			return cart.getCartItem();
		}
		return null;
	}
	
	

}
