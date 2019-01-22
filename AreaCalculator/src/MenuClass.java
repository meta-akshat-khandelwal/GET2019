import java.util.*;


/*
 * Main Driver Class
 */
public class MenuClass {

	/*
	 * showMenu method is used to show the option to the user
	 * @param doesnot require any parameter
	 * @return doesn't return any value 
	 */
	public void showMenu()
	{
		System.out.println("Choose the option below");
		System.out.println("Press 1 to calculate the area of triangle");
		System.out.println("Press 2 to calculate the area of rectangle");
		System.out.println("Press 3 to calculate the area of square");
		System.out.println("Press 4 to calculate the area of Circle");
		System.out.println("Press 0 to exit");
	}
	
	
	/*
	 * checkDouble method to check whether the input is String or not
	 * @param input which holds the value given by the user 
	 * @return the boolean value true of the value is an double and false if not.
	 */
	public double checkDouble(String input)
	{
		double result=-1;
		try
		{
			result=Double.parseDouble(input);
			
		}
		
		catch(Exception e)
		{
			System.out.println("Please provide valid input..");
			return result;
		}
		
		return result;
	}
	
	public static void main(String args[])
	{
		MenuClass menuClass= new MenuClass();
		double result;
		int userChoice;
		String input1, input2;
		menuClass.showMenu();
		Scanner sc= new Scanner(System.in);
		userChoice=sc.nextInt();
		Area area= new Area();
		while(userChoice!=0)
		{
			
			
			
			switch(userChoice)
			{
			case 1:   double baseOfTriangle,heightofTriangle;
			           System.out.println("Please Enter the base of triangle");
			           input1=sc.next();
			         
			           baseOfTriangle=menuClass.checkDouble(input1);
			           if(baseOfTriangle!= -1)
			           {
			           System.out.println("Please Enter the height of triangle");
		
			           input2=sc.next();
			           
			           heightofTriangle=menuClass.checkDouble(input2);
			         
			           if( heightofTriangle!= -1)
			           {
			          
			          try{
			         result= area.calculateTriangleArea(baseOfTriangle, heightofTriangle);
			          System.out.println("Area is "+result);
			          }
			          catch(Exception e)
			          {
			        	  System.out.println("Arithmetic Exception occurred");
			          }
			           }
			           }
			           
			      
				break;
			case 2:        double lengthOfRectangle,bredthOfRectangle;
			              System.out.println("Please enter length of rectangle");
			              input1=sc.next();
					         
			              lengthOfRectangle=menuClass.checkDouble(input1);
			              if(lengthOfRectangle!= -1)
				           {
		              	System.out.println("Please enter bredth of rectangle");
		              	input2=sc.next();
				         
		              	bredthOfRectangle=menuClass.checkDouble(input2);
		              	
		            	
		             if(bredthOfRectangle!=-1)
		        		{	  
		            	try
		            	{
		            	result=area.calculateRectangleArea(lengthOfRectangle, bredthOfRectangle);
		            	System.out.println("Area is "+result);
		            	}
		            	catch(Exception e)
				          {
				        	  System.out.println("Arithmetic Exception occurred");
				          }
		        		}
		            	 
				           }
			           	break;
			case 3:   double sideOfSquare;
			            System.out.println("Please enter length of side ");
			            
			            input1=sc.next();
				         
			            sideOfSquare=menuClass.checkDouble(input1);
			         
			           if(sideOfSquare!=-1)
			           {
			           try
			           {
			           result= area.calculateSquareArea(sideOfSquare);
			           System.out.println("Area is "+result);
			           }
			           catch(Exception e)
				          {
				        	  System.out.println("Arithmetic Exception occurred");
				          }
			           }
			           
			           
				       break;
			case 4:      double radiusOfCircle;
			           System.out.println("please Enter the radius of circle");
			          
			           input1=sc.next();
				         
			           radiusOfCircle=menuClass.checkDouble(input1);
			           if(radiusOfCircle!=-1)
			           {
			           try
			           {
			           result= area.calculateCircleArea(radiusOfCircle);
			           System.out.println("Area is "+result);
			           }
			           catch(Exception e)
				          {
				        	  System.out.println("Arithmetic Exception occurred");
				          }
			           }
			           
				break;
			case 0: System.exit(0);
			    break;
			default: System.out.println("Invalid Choice.. Please re enter your choice.. ");
			
			}
			
			menuClass.showMenu();
			
			userChoice=sc.nextInt();
		
		}
		sc.close();
	}
	
	
}
