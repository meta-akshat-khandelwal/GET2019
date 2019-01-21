// base converter class

public class Convert {

	 char numberList[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
	 String directory = "0123456789ABCDEF"; 
	
	public  String decimalToAny(String num,int base)					// decimal base to any base conversion
	{
		String result="";
		int number = Integer.parseInt(num);
	    
		int remender;
		
		while(number>0)  
		{  
			remender=number%base;
		  result=numberList[remender]+result;   
		  number=number/base;  
		}  
		
		
		 return result;
	}
	

	
	public  String anyToDecimal(int base, String num)					// any base to decimal base conversion
	{
		 
      
        int val = 0;  
        for (int i = 0; i < num.length(); i++)  
        {  
            char c = num.charAt(i);  
            int d = directory.indexOf(c);  
            val=val+(int)(Math.pow(base, num.length()-i-1)*d);
            
        }  
        return ""+val;  
	}
	
	public  String anyConvert(String num,int base1, int base2)								// any base to any base conversion
	{
		String result1=anyToDecimal(base1,num);
		String result2=decimalToAny(result1,base2);
		return result2;
	}
	
	
}
