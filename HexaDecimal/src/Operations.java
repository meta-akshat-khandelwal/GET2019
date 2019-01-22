// for 
public class Operations {

	public String add(String number1, String number2)							// addition operation
	{
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);
		return ""+(num1+num2);
	}
	
	public String subtract(String number1, String number2)					// subtraction operation
	{
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);
		return ""+(num1-num2);
	}
	
	public String multiply(String number1, String number2)						// multiplication operation
	{
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);
		return ""+(num1*num2);
	}
	
	public String divide(String number1, String number2)						// divison operation
	{
		int num1=Integer.parseInt(number1);
		int num2=Integer.parseInt(number2);

		return ""+(num1/num2);
	
	}
		
	public boolean greater(String number1,String number2)						// greater than operation
	{
		if(number1.length()<number2.length())
			return false;
		if(number1.length()>number2.length())
			return true;
			
		boolean flg=false;
		String directory = "0123456789ABCDEF";  
	      
	      
	        for (int i = 0; i < number1.length(); i++)  
	        {  
	            char c1 = number1.charAt(i);  
	            int d1 = directory.indexOf(c1);  
	            char c2 = number2.charAt(i);  
	            int d2 = directory.indexOf(c2);  
	            if(d1>d2)
	            {
	            	flg=true;
	            	break;
	            }
	            
	            
	        }  
	      
		return flg;
		
	}
	
	
	public boolean lesser(String number1,String number2)					// lesser than operation
	{
		if(number1.length()>number2.length())
			return false;
		if(number1.length()<number2.length())
			return true;
			
		boolean flg=false;
		String directory = "0123456789ABCDEF";  
	      
	      
	        for (int i = 0; i < number1.length(); i++)  
	        {  
	            char c1 = number1.charAt(i);  
	            int d1 = directory.indexOf(c1);  
	            char c2 = number2.charAt(i);  
	            int d2 = directory.indexOf(c2);  
	            if(d1<d2)
	            {
	            	flg=true;
	            	break;
	            }
	            
	            
	        }  
	      
		return flg;
		
	}
	
	
	public boolean equalTo(String number1,String number2)						// equal to operation
			{
		if(number1.length()!=number2.length())
			return false;
		
		String directory = "0123456789ABCDEF";  
	      
		boolean flg=true;
        for (int i = 0; i < number1.length(); i++)  
        {  
            char c1 = number1.charAt(i);  
            int d1 = directory.indexOf(c1);  
            char c2 = number2.charAt(i);  
            int d2 = directory.indexOf(c2);  
            if(d1<d2 || d1>d2)
            {
            	flg=false;
            	break;
            }
		
			}
	return flg;
			}
}
