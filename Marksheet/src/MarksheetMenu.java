import java.util.*;
import java.text.DecimalFormat;
public class MarksheetMenu {
	
	//to round the values up to 2 decimal values
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		
		
	/*
	 * showMenu method is used to show the option to the user
	 * @param, doesnot require any parameter
	 * @return doesn't return any value 
	 */
	
	public void showMenu()
	{	
		System.out.println("Choose the option below");
		System.out.println("Press 1 to find average of all grades");
		System.out.println("Press 2 to find maximum from all grades");
		System.out.println("Press 3 to find minimum from all grades" );
		System.out.println("Press 4 to find % of passed students ");
		System.out.println("Press 5 to Exit");	
	}
	
	
	/*
	 * checkInputInteger method use to check the input is integer or not and also should not be less than zero
	 * @param requires an input string which contains the input given by the user and should not be null
	 * @return the integer value inserted by the user if it is integer
	 */
	public int checkInputInteger(String input)
	{
		int result=-1;
		try
		{
			result=Integer.parseInt(input);
			
		}
		
		catch(Exception e)
		{
			System.out.println("Please provide valid input..");
			return result;
		}
		
		return result;
		
			
	}
	
	/*
	 * checkInputDouble method use to check the input is double or not and also should not be less than zero
	 * @param requires an input string which contains the input given by the user and should not be null
	 * @return the double value inserted by the user if it is double
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
		
		MarksheetMenu marksheetMenu = new MarksheetMenu();
		Marksheet marksheet = new Marksheet();
		Scanner sc = new Scanner(System.in);
		
		String tempInput="";
		double result,tempDoubleInput;
		int userChoice=0,numberOfStudents=0,loop;
		boolean flag=false;
		
		System.out.println("Enter the number of students....");
		
		//loop to check the number_of_students has valid input or not
		while(!flag)
		{
			tempInput=sc.next();
			
			numberOfStudents=marksheetMenu.checkInputInteger(tempInput);
			if(numberOfStudents==0 )
			{
				System.out.println("Number of students can't be zero");
			}
			else
				if(numberOfStudents!=-1)
			{
				flag=true;
			}
		}	
			
		//loop to enter the grades into the marks arraylist of Marksheet Class
		for(loop=0 ; loop<numberOfStudents ; loop++)
		{
			
			flag=false;
			
			System.out.println("Enter the grade of student "+(loop+1)+"...");
			
			while(!flag)
			{
				
				tempDoubleInput=marksheetMenu.checkDouble(sc.next());
				
				if((tempDoubleInput>=100 || tempDoubleInput==-1) || tempDoubleInput<=0)
				{
					System.out.println("Grade should be between 0 to 100!!!\nPlease Re-Enter...");
					flag=false;
				}
				
				else
				{
					flag=marksheet.addGrades(tempDoubleInput);
				}
				
			}
			
		}
		
		marksheetMenu.showMenu();
		userChoice=marksheetMenu.checkInputInteger(sc.next());
		
		while(userChoice != 5)
		{
			
		
			
			switch(userChoice)
			{
			
			case 1:
				
				try
				{
					result = marksheet.returnAverageOfGrades();
					System.out.println("The average of all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception occurred");
				}
				
				break;
				
			case 2:
				
				try
				{
					result = marksheet.returnMaximumOfGrades();
					System.out.println("The maximum from all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
				
				break;
				
			case 3:
				
				try
				{
					result = marksheet.returnMinimumOfGrades();
					System.out.println("The minimum from all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
					
				break;
				
			case 4:
				
				try
				{
					result = marksheet.returnPercentageOfPassed();
					System.out.println("The percentange of student passed is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
				
				break;
				
			case 5:
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Invalid Choice!!!");
			}
			
			System.out.println();
			
			marksheetMenu.showMenu();
			userChoice=marksheetMenu.checkInputInteger(sc.next());

		}
		
	sc.close();
	
	}
	
}
