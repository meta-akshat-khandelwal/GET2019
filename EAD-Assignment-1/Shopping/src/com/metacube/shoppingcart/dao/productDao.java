package com.metacube.shoppingcart.dao;

import java.util.ArrayList;

import com.metacube.shoppingcart.enums.status;
import com.metacube.shoppingcart.model.Product;

public class productDao implements BaseDao<Product> {
	
	
	
	Store s=Store.getInstance();
	
	
	ArrayList<Product> productList= s.getProductList();
	
	@Override
	public status add(Product product)
	{
		if(productList.add(product))
		{
			return status.SUCCESSFULL;
		}
		
		return status.NOTSUCESSFULL;
		
	}
	
	@Override
	public status delete(Product product)
	{
		if(productList.remove(product))
		return status.SUCCESSFULL;
		
		return status.NOTSUCESSFULL;
	}
	
	@Override
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
