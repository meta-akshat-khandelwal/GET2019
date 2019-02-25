package com.metacube.shoppingCart.facade;

import java.util.ArrayList;

import com.metacube.shoppingCart.dao.productDao;
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
public class ProductFacade {

	productDao productdao= new productDao();
    ArrayList<Product> listOfproduct=productdao.getAllProduct();
	
    /*
     * adds product to store
     * @param, product
     * @returns status
     */
	public status addProduct(Product product)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode()==product.getCode())
		{
			System.out.println("duplicate");
			return status.DUPLICATE;
			
		}
		}
		
		    productdao.add(product);
			System.out.println("success");
			return status.SUCCESSFULL;
	}
	
	/*
	 * Gives all products in store
	 * @returns list of all products in store
	 */
	public ArrayList<Product> getAllProduct()
	{
		return listOfproduct;
	}
	
	/*
	 * deletes product from store
	 * @param product
	 * @returns status
	 */
	public status deleteProduct(Product product)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode()==product.getCode())
		{
			productdao.delete(listOfproduct.get(i));
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
		
	}
	
	/*
	 * updates the product in store
	 * @param, product
	 * @returns status
	 */
	public status updateProduct(Product product)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode()==product.getCode())
		{
			System.out.println(listOfproduct.get(i).getCode());
			productdao.update(listOfproduct.get(i), product);
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
	}
	
	/*
	 * updates quantity of product in store
	 *@param, code of product
	 *@param quantity of product
	 *Returns status 
	 */
	public status updateProductQuantity(int code,int qty)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			if(listOfproduct.get(i).getCode() == code)
			{
				listOfproduct.get(i).setQty(qty);
				return status.SUCCESSFULL;
			}
			
				
		}
		return status.NOTSUCESSFULL;
	}
	
	/*
	 * Get product corresponding to its code
	 * @param, code of product
	 * @returns status
	 */
	public Product getProduct(int code)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode() == code)
		{
			return listOfproduct.get(i);
		}
		}
		return null;
		
	}
	
	
	
}
