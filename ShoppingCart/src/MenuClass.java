import java.util.Scanner;


public class MenuClass {

	public void showMenu()
	{
		
		System.out.println("Press 1 to Add Item to Cart");
		System.out.println("Press 2 View Cart");
		System.out.println("Press 0 to Exit");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO STORE ");
		MenuClass menu= new MenuClass();
		Item item = new Item();
		item.addToStock();
		item.showItem();
		menu.showMenu();
		
		
		Scanner sc = new Scanner(System.in);
		int choice=sc.nextInt();
		int cartChoice,tempQty=0,modQty,modId;
		Cart cart= new Cart();
		while(choice!=0)
		{
		
			switch(choice)
			{
			case 1:System.out.println("Please Enter the product id to add in cart..");
				   cartChoice=sc.nextInt();
				   
				  
				   if(item.checkItem(cartChoice)==false)
			       {
			    	   System.out.println("Invalid Choice...");
			    	   
			    	   
			       }
			      
			       
			       
				   else
				   {
			    	   System.out.println("Please Enter the Quantity..");
				       tempQty=sc.nextInt();
				       
			      if(item.checkQty(cartChoice, tempQty))
			       {
			    	  if(!(cart.checkProductInCart(cartChoice)))
			    	  {
			    	  cart.addToCart(item.stock.get(cartChoice-1).getProductName(),item.stock.get(cartChoice-1).getProductId(),item.stock.get(cartChoice-1).getProductPrice(),tempQty);
				       item.updateItem(cartChoice, tempQty);
			    	  }
			    	  
			    	  else
			    	  {
			    		  cart.updateCart(cartChoice, tempQty);
			    		  item.updateItem(cartChoice, tempQty);
			    	  }
			       }
			       
			     
				  }
		   
			      
			       	break;
			case 2: cart.showCart();
					System.out.println("Press 1 to add more products..");
					System.out.println("Press 2 to modify the product quantity..");
					System.out.println("Press 3 to generate final bill..");
					
					cartChoice=sc.nextInt();
					
					
					switch(cartChoice)
					{
						case 1: choice=1;
							    break;
						case 2: 
							          
							    
							    System.out.println("Please Enter the product id..");
						         modId=sc.nextInt();
						          if( cart.checkItem(modId)==true)
						             {
						            	 System.out.println("Please Enter the product quantity");
						            	 modQty=sc.nextInt();
						            	 if(item.checkQty(modId, modQty)==true)
									       { 
						            	if( cart.modifyCart(modId, modQty)==true)
						            		{
						            		System.out.println("successfull..");
						            		item.modifyItemQty(modId, modQty);
						            		cart.showCart();
						            		}
						            	else
						            		System.out.println("Please try again");
						             }
						             }
						              
							break;
						case 3 :	if(cart.finalBill()!=-1)
									System.out.println("Your Final bill is..."+cart.finalBill());
									else
										System.out.println("Your cart is empty");
									System.out.println("Thank you...");
										System.exit(0);
							break;	
						default: System.out.println("Invalid Choice...");	
						break;
						}
					
					
					
			break;
			case 0:   System.out.println("Thank you...");
				     System.exit(0);
						break;
			default: System.out.println("Invalid Choice...");	
			break;
			
		}
			
			item.showItem();
			menu.showMenu();
			choice=sc.nextInt();
					
		
		
	}
			sc.close();
	}
	}
