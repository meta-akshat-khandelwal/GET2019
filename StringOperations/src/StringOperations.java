/*
* Main Driver Class
*/
public class StringOperations 
{
	/*
	 * reverseOfInputString method returns the reverse of input String
	 * @param inputString holds the input String by user and should not be null
	 * Return the reverString of String type which holds the reverse of String  
	 */
	
	public String reverseOfInputString(String inputString)
	{
		
		int lengthOfString;
		String reverseString="";
		
		lengthOfString=inputString.length();
		
		for(int loop=0;loop<lengthOfString;loop++)
		{
			reverseString=inputString.charAt(loop)+reverseString;
		}
		
		return reverseString;
	}
	
	
	/*
	 * changeCaseInString method used to change the case in the String from Uppercase to lowercase and vice-versa
	 * @param inputString of type string which holds the input String  by the user and should be not NULL
	 * @return resultantString which contains the changed String
	 */
	
	public String changeCaseInString(String inputString)
	{
		
		int loop,lengthOfString,asciValue;
		char currentChar;
		String resultantString="";
		
		lengthOfString=inputString.length();
		
		for(loop=0;loop<lengthOfString;loop++)
		{
			
			currentChar=inputString.charAt(loop);
			asciValue=(int)currentChar;
			
			if(asciValue>=65 && asciValue <=90)				
				asciValue=asciValue+32;

			else if(asciValue >=97 && asciValue <=122)
				asciValue=asciValue-32;

			resultantString=resultantString+(char)asciValue;
		}
		
		return resultantString;
	}
	
	/*
	 * compareTwoString method used to compare two strings which are case sensitive 
	 * @param inputString1 which holds the first string  by the user,String should not be NULL
	 * @param inputString2 which holds the first string  by the user,String should not be NULL
	 * @return 0 if both strings are equal and -1 if two strings are not equal
	 */
	
	public int compareTwoString(String inputString1 , String inputString2)
	{
		
		inputString2=inputString2.trim();   		// remove extra space from input String
		inputString1=inputString1.trim();         // remove extra space from input String
		
		if(inputString1.length()!=inputString2.length())
			return -1;
		
		else
		{
			for(int loop=0;loop<inputString1.length();loop++)
			{	
				if(inputString1.charAt(loop)!=inputString2.charAt(loop))
					return -1;	
			}
			
			return 0;
			
		}
	}
	
	/*
	 * maximumLengthWordFromString method is used to find the word of maximum length and if two word are of same length then  it returns the last word from the sentence
	 * @param inputString which contains the sentence  by the user, it should not be NULL
	 * #return the word of maximum length from the input string
	 */
	public String maximumLengthWordFromString(String inputString)
	{
		
		String maxLengthWord="";
		String currentWord="";
		int loop;
		
		for(loop=0;loop<inputString.length();loop++)
		{
			
			if(inputString.charAt(loop)!=' ' && ((int)inputString.charAt(loop)>=65 && (int)inputString.charAt(loop)<=90) || ((int)inputString.charAt(loop)>=97 && (int)inputString.charAt(loop)<=122) || ((int)inputString.charAt(loop)>=48 && (int)inputString.charAt(loop)<=57)) 				
				currentWord=currentWord+inputString.charAt(loop);

			
			else if(inputString.charAt(loop)==' ')
				currentWord="";
			
			
			if(currentWord.length()>=maxLengthWord.length())
				maxLengthWord=currentWord;
			
		}
		
		return maxLengthWord;
	}
	
}


