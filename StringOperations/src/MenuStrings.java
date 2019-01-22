
   /*
    * Main Driver Class
    */

	import java.util.Scanner;

	public class MenuStrings 
	{
		
		/*
		 * showMenu method is used to show the option to the user
		 * @param doesnot require any parameter
		 * @return doesn't return any value 
		 */
		public void showMenu()
		{	
			System.out.println("Choose the option below");
			System.out.println("1. Compare Two Strings");
			System.out.println("2. Reverse the given String");
			System.out.println("3. To modify the Strings (lower to upper case or vice versa)");
			System.out.println("4. Find largest word");
			System.out.println("5. Exit");	
		}
		
		/*
		 * checkInputInteger method is used to check the input should be integer only
		 * @param input of type string which holds the input given by user, assuming input should not be NULL
		 * @return a boolean value true if the input is Integer and false in it is not an Integer
		 */
		public boolean checkInputInteger(String input)
		{
			
			try
			{
				 new Integer(input);
			}
			
			catch (Exception e) 
			{
				
				return false;
			}
			
			return true;
		}
		
		public static void main(String args[])
		{
			
			Scanner sc = new Scanner(System.in);
			MenuStrings menuStrings = new MenuStrings();
			StringOperations stringOperations = new StringOperations();
			
			String inputString1,inputString2,resultantString;
			int userChoice=0,result;
			boolean flag=false;
			String temp_input;
			
			menuStrings.showMenu();
			
			while(!flag)								
			{
				
				temp_input=sc.next();
				flag=menuStrings.checkInputInteger(temp_input);
				
				if(!flag)
				{		
					System.out.println("Integers values !!!");
					System.out.println("Please re-Enter the choice");
					menuStrings.showMenu();	
				}
				
				else
				{
					userChoice=Integer.parseInt(temp_input);
				}
				
			}
			
			while( userChoice != 5)
			{
				
				flag=false;							
				
				switch(userChoice)                 
				{
				
				case 1:
					
					System.out.println("Enter the first String...");
					sc.nextLine();
					inputString1=sc.nextLine();
					
					System.out.println("Enter the second string...");
					inputString2=sc.nextLine();
					
					result=stringOperations.compareTwoString(inputString1, inputString2);
					
					if(result == -1)
						System.out.println("Both Strings are not equal..");
					else
						System.out.println("Both Strings are equal..");
					
					break;
					
				case 2:
					
					System.out.println("Enter the string to be reversed....");
					sc.nextLine();
					inputString1=sc.nextLine();
					
					resultantString=stringOperations.reverseOfInputString(inputString1);
					
					System.out.println(resultantString);
					
					break;
					
				case 3:
					
					System.out.println("Enter the string to be modified...");
					sc.nextLine();
					inputString1=sc.nextLine();
					
					resultantString=stringOperations.changeCaseInString(inputString1);
					
					System.out.println(resultantString);
					
					break;
					
				case 4:
					
					System.out.println("Enter the sentence to find the largest word...");
					sc.nextLine();
					inputString1=sc.nextLine();
					
					resultantString=stringOperations.maximumLengthWordFromString(inputString1);
					
					System.out.println(resultantString);
					
					break;
					
				case 5:
					
					System.exit(0);
					
					break;
					
				default:
					
					System.out.println("Invalid Choice");
					
				}
				
			menuStrings.showMenu();
			
			while(!flag)				//loop checks for the input given by the user should be an integer
			{
				
				temp_input=sc.next();
				
				flag=menuStrings.checkInputInteger(temp_input);
				
				if(!flag)
				{
					System.out.println("Only Integers!!!");
					System.out.println("Re-Enter the choice");
					menuStrings.showMenu();
				}
				
				else
				{
					userChoice=Integer.parseInt(temp_input);
				}
				
			}
				
			}
			
			sc.close();
		}
	}


