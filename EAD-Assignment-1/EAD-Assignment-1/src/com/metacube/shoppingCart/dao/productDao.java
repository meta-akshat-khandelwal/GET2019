
package com.metacube.shoppingCart.dao;

import java.util.ArrayList;

import com.metacube.shoppingCart.dao.Store;
import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Product;

public class productDao {

	
	Store s=Store.getInstance();
	
	
	ArrayList<Product> productList= s.getProductList();
	
	
	public status add(Product product)
	{
		if(productList.add(product))
		{
			return status.SUCCESSFULL;
		}
		
		return status.NOTSUCESSFULL;
		
	}
	
	
	public status delete(Product product)
	{
		if(productList.remove(product))
		return status.SUCCESSFULL;
		
		return status.NOTSUCESSFULL;
	}
	
	
	public status update(Product product, Product updateProduct)
	{
		int index;
		index= productList.indexOf(product);
		productList.remove(index);
		productList.add(updateProduct);
		return status.SUCCESSFULL;
	}
	
	public ArrayList<Product> getAllProduct()
	{
		return productList;
	}
	
}
