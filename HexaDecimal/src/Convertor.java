import java.util.*;

// driver class
public class Convertor {

	
	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		Convert convert =new Convert();
		Operations operations= new Operations();
		String result1,number1,number2,result2;
		int base=16;			// for base
		boolean answer;
		
		
		System.out.println("Press 1 for converting  hexadecimal number into decimal number ");
		System.out.println("Press 2 for converting number into hexadecimal number");
		System.out.println("Press 3 for addition ");
		System.out.println("press 4 for subtraction");
		System.out.println("press 5 for multiplication ");
		System.out.println("press 6 for divide ");
		System.out.println("press 7 to check first number is greater to second ? ");
		System.out.println("press 8 to check first number is smaller to second ? ");
		System.out.println("press 9 to check first number is equal to second ? ");
		System.out.println("press 0 to exit ");
		int choice= sc.nextInt();
		
		switch(choice)
		{
		case 1 :System.out.println("Please Enter the  hexadecimal number..");			// for decimal conversion
		number1=sc.next();
				result1=convert.anyToDecimal(base,number1);
				System.out.println("Answer is "+result1);
			     break;
		
		case 2 :	System.out.println("Please Enter the  decimal number..");			// for hexadecimal conversion
					 number1=sc.next();
					result1=convert.decimalToAny(number1,base);
					System.out.println("Answer is "+result1);
					break;
				
		case 3:  	System.out.println("Please Enter the first hexanumber..");			// for hexadecimal addition
					 number1=sc.next();
					System.out.println("Please Enter the second hexanumber..");
					 number2= sc.next();
					 result1=convert.anyToDecimal(base,number1);
					 result2=convert.anyToDecimal(base,number2);
					 System.out.println("Answer is "+convert.decimalToAny(operations.add(result1, result2),base));
					 
				break;

		case 4: System.out.println("Please Enter the first hexanumber..");				// for hexadecimal subtraction
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 result1=convert.anyToDecimal(base,number1);
		 result2=convert.anyToDecimal(base,number2);
		 System.out.println("Answer is "+convert.decimalToAny(operations.subtract(result1, result2),base));
		 
				break;
		case 5: System.out.println("Please Enter the first hexanumber..");				// for hexadecimal multiplication
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 result1=convert.anyToDecimal(base,number1);
		 result2=convert.anyToDecimal(base,number2);
		 System.out.println("Answer is "+convert.decimalToAny(operations.multiply(result1, result2),base));
		 
				break;
		case 6 :	System.out.println("Please Enter the first hexanumber..");			// for hexadecimal division
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 result1=convert.anyToDecimal(base,number1);
		 result2=convert.anyToDecimal(base,number2);
		 if("0".equals(result2))
			 System.out.println("Invalid input");
		 else
		 System.out.println("Answer is "+convert.decimalToAny(operations.divide(result1, result2),base));
		 
			break;
		case 7 :	System.out.println("Please Enter the first hexanumber..");				// for greater than operation
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 		 answer=	operations.greater(number1, number2);
		 		if(answer==true)
		 			System.out.println("first number is greater ");
		 		else
		 			System.out.println("first number is not greater");
			break;
		case 8 :	System.out.println("Please Enter the first hexanumber..");				// for lesser than operation
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 		answer=	operations.lesser(number1, number2);
		 		if(answer==true)
		 			System.out.println("first number is greater ");
		 		else
		 			System.out.println("first number is not greater");
			break;
		case 9 :	System.out.println("Please Enter the first hexanumber..");					// for equal to operation
		 number1=sc.next();
		System.out.println("Please Enter the second hexanumber..");
		 number2= sc.next();
		 		answer=	operations.equalTo(number1, number2);
		 		if(answer==true)
		 			System.out.println(" numbers are equal ");
		 		else
		 			System.out.println(" numbers are not equal");
			
			break;
		case 0: System.exit(0);																	// for exit
				break;
		default:System.out.println("Invalid choice ");
				
		}
		
		
		
		
	}

}
