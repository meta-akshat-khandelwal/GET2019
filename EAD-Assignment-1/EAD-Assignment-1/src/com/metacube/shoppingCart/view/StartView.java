package com.metacube.shoppingCart.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.metacube.shoppingCart.controller.CartController;
import com.metacube.shoppingCart.controller.UserController;
import com.metacube.shoppingCart.enums.status;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.facade.UserFacade;
import com.metacube.shoppingCart.model.Item;
import com.metacube.shoppingCart.model.Product;
import com.metacube.shoppingCart.model.User;

public class StartView {

	
	
	public void showMainMenu()
	{
		System.out.println("Press 1 to Add Item to Cart");
		System.out.println("Press 2 View Cart");
		System.out.println("Press 0 to Exit");
	}
	
	public void ShowCartMenu()
	{
		System.out.println("Press 1 to add more products..");
		System.out.println("Press 2 to modify the product quantity..");
		System.out.println("Press 3 to remove Product from cart..");
		System.out.println("Press 4 to generate final bill..");
		
	}
	
	public void showProducts()
	{	
		ProductFacade productFacade= new ProductFacade();
		ArrayList<Product> productlist= productFacade.getAllProduct();
		for(int i=0;i<productlist.size();i++)
		{
			Product product= productlist.get(i);
			System.out.println(product.getCode()+"\t"+product.getName()+
					                     "\t\t"+product.getType()+"\t\t"+product.getPrice()+
				                        	"\t\t"+product.getQty());
		}
	}
	
	
	
public static void main(String args[])
{
     	System.out.println("Welcome to dream store........");
		Scanner sc= new Scanner(System.in);
		StartView startview = new StartView();
		UserController userController= new UserController();
		UserFacade userFacade= new UserFacade();
		ProductFacade productFacade= new ProductFacade();
		CartController cartController= new CartController();
		
		int userid=1001;
		System.out.println("Can I know your name");
		String name=sc.next();
		User user=userController.createUser(userid,name);
		System.out.println("\n Your User Id is "+user.getId()+"\n");
		startview.showProducts();
		startview.showMainMenu();
		int cartChoice;
		int choice=sc.nextInt();
		int productid,productQty; 
		int billAmount=0,cartProductId,cartProductQty;
		status result;
		while(choice >= 0)
		{
			
			switch(choice)
			{
			case 1: try
					{	
				    System.out.println("Enter Product Id..");
					productid=sc.nextInt();
					
					System.out.println("Enter Quantity..");
					productQty=sc.nextInt();
					
					result=cartController.addItem(productid, productQty);
					if(status.SUCCESSFULL == result)
						System.out.println("Success");
					if(status.DUPLICATE == result)
						System.out.println("Already exists in your cart..");
					if(status.NOTSUCESSFULL == result)
							System.out.println("Please re-enter with correct choice..");
					if(status.NOTAVAILABLE == result)
					   System.out.println("This much of quantity is not available..");
					}
					catch(Exception e)
						{
						System.out.println("Invalid Input");
						}
			          break;
			          
			case 2: 	ArrayList<Item> cartList = cartController.getCart();
						 for(int i=0;i<cartList.size();i++)
						 {
							 Item item= cartList.get(i);
							 System.out.println(item.getCode()+"\t"+item.getName()+
				                     "\t\t"+item.getType()+"\t\t"+item.getPrice()+
			                        	"\t\t"+item.getQty());
						 }
						startview.ShowCartMenu();
						  
						cartChoice=sc.nextInt();
						
						  switch(cartChoice)
						  {
						  case 1:break;
						  
						  case 2: System.out.println("Enter Product Id  ");
						  			cartProductId=sc.nextInt();
						  			System.out.println("Enter Product Quantity ");
						  			cartProductQty=sc.nextInt();
						  		    result=cartController.updateItem(cartProductId, cartProductQty);	
						  			if(status.SUCCESSFULL == result)
										System.out.println("Success");
									if(status.DUPLICATE == result)
										System.out.println("Already exists in your cart..");
									if(status.NOTSUCESSFULL == result)
											System.out.println("Please re-enter with correct choice..");
									if(status.NOTAVAILABLE == result)
									   System.out.println("This much of quantity is not available..");
									
						  			break;
						  			
						  case 3:	System.out.println("Enter Product Id  ");
				  			        cartProductId=sc.nextInt();		
				  			        result= cartController.removeItem(cartProductId);
				  			        if(status.SUCCESSFULL == result)
										System.out.println("Success");
				  			        if(status.NOTSUCESSFULL == result)
				  			        	System.out.println("Product Not exists in cart");
				  			        break;
				  			        
						  case 4:   ArrayList<Item> cart = cartController.getCart();
							     for(int i=0;i<cartList.size();i++)
							     {
								 Item item= cartList.get(i);
								 System.out.println(item.getCode()+"\t"+item.getName()+
					                     "\t\t"+item.getType()+"\t\t"+item.getPrice()+
				                        	"\t\t"+item.getQty());
								 billAmount=billAmount+(item.getPrice()*item.getQty());
							      } 
							     System.out.println("Hello "+user.getName());
							     System.out.println("Your final bill is "+billAmount);
							     System.out.println("Thank You..");
							     System.exit(0);
							    
						  
						  }
						  
				
				
				break;
			case 0: System.out.println("Thank You..");
					System.exit(0);
						break;
			default:System.out.println("Invalid Choice..\n");
			}
			
			startview.showProducts();
			startview.showMainMenu();
			choice=sc.nextInt();
		
		}
   
 		
		
		sc.close();
}    
	}


