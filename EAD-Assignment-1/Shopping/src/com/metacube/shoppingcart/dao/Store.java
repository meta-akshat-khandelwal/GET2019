package com.metacube.shoppingcart.dao;

import java.util.ArrayList;

import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.model.User;

public class Store {
	
	private static Store obj=null;
	private ArrayList<User> userList= new ArrayList<User>();
	private ArrayList<Product> productList= new ArrayList<Product>();
	
	
	   private Store(){
	     Product p1= new Product(1,"shirts","clothing",1000,10);
	     Product p2= new Product(2,"chips","snacks",50,150);
	     Product p3= new Product(3,"jeans","clothing",1800,8);
	     Product p4= new Product(4,"I-Phone X","mobile",1500,5);
	     Product p5= new Product(5,"Real juice","juice",100,30);
	     Product p6= new Product(6,"Rado","watch",1500,10);
	     Product p7= new Product(7,"BMW","car",5000,8);
	     Product p8= new Product(8,"Asus Rog","laptop",150,20);
	     Product p9= new Product(9,"pixel 3","mobile",800,15);
	     Product p10= new Product(10,"casio","watch",900,20);
	     
	     productList.add(p1);
	     productList.add(p2);
	     productList.add(p3);
	     productList.add(p4);
	     productList.add(p5);
	     productList.add(p6);
	     productList.add(p7);
	     productList.add(p8);
	     productList.add(p9);
	     productList.add(p10);
	     
	   }
	   
	   				
	   public static Store getInstance(){
		/*This logic will ensure that no more than
		 * one object can be created at a time */
		if(obj==null){
		    obj= new Store();
		}
	        return obj;
	   }
	   
	   
	   public  ArrayList<User> getUserList()
	   {
		   return userList;
	   }
	   
	   public  ArrayList<Product> getProductList()
	   {
		   return productList;
	   }
	  
	  

}
