
package com.metacube.shoppingCart.dao;

import java.util.ArrayList;

import com.metacube.shoppingCart.dao.Store;
import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.model.Product;
/**
 * performs the following task:
 * 1. Add the Product to store
 * 2. removes the product from store
 * 3. updates the product  in store
 * 4. Return list of products
 * @author Akshat
 *
 */
public class productDao {

	
	Store s=Store.getInstance();
	
	
	ArrayList<Product> productList= s.getProductList();
	
	/*
	 * adds the product to store
	 * @param, Product to be added
	 * @returns status 
	 */
	public status add(Product product)
	{
		if(productList.add(product))
		{
			return status.SUCCESSFULL;
		}
		
		return status.NOTSUCESSFULL;
		
	}
	
	/*
	 * deletes the product from store
	 * @param, product to be delete
	 * @returns status
	 */
	public status delete(Product product)
	{
		if(productList.remove(product))
		return status.SUCCESSFULL;
		
		return status.NOTSUCESSFULL;
	}
	
	/*
	 * Updates product in store
	 * @param, old product 
	 * @param new product
	 * @returns status
	 */
	public status update(Product product, Product updateProduct)
	{
		int index;
		index= productList.indexOf(product);
		productList.remove(index);
		productList.add(updateProduct);
		return status.SUCCESSFULL;
	}
	
	/*
	 *Get list of all products
	 *returns list of products 
	 */
	public ArrayList<Product> getAllProduct()
	{
		return productList;
	}
	
}
