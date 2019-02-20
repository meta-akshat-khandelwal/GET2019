package com.metacube.shoppingcart.facade;

import java.util.ArrayList;


import com.metacube.shoppingcart.dao.productDao;
import com.metacube.shoppingcart.enums.status;
import com.metacube.shoppingcart.model.Product;


public class ProductFacade {

	productDao productdao= new productDao();
    ArrayList<Product> listOfproduct=productdao.getAllProduct();
	
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
	
	
	public status deleteProduct(Product product)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode()==product.getCode())
		{
			productdao.delete(listOfproduct.get(i));
			System.out.println("deleted");
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
		
	}
	
	
	public status updateProduct(Product product)
	{
		for(int i=0;i<listOfproduct.size();i++)
		{
			
		if(listOfproduct.get(i).getCode()==product.getCode())
		{
			System.out.println(listOfproduct.get(i).getCode());
			productdao.update(listOfproduct.get(i), product);
			System.out.println("updated");
			return status.SUCCESSFULL;
			
		}
		}
		return status.NOTSUCESSFULL;
	}
	
	
//	public static void main(String args[])
//	{
//		productDao pro= new productDao();
////		ArrayList<Product> li= pro.getAllProduct();
//		
//		Product p1= new Product(1, "asdf", "qwer", 1200);
//		Product p2= new Product(2,"zxcv","qwer",1800);
//		Product p3= new Product(1, "a", "qwer", 1200); //
//		Product p4= new Product(1, "poiu", "qwr", 1200);
//		ProductFacade facade= new ProductFacade();
//		
//		facade.addProduct(p1);
//		facade.addProduct(p2);
//		facade.addProduct(p3);
//		facade.updateProduct(p4);
//		facade.deleteProduct(p2);
//		
//		
//		ArrayList<Product> li= pro.getAllProduct();
//		
//		for(int i=0;i<li.size();i++)
//		{
//			System.out.println(li.get(i).getName());
//			System.out.println(li.size());
//		}
//		
//		
//		
//	}
//	
	
}
