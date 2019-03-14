package Question2;
/**
 * Converts the infix to post-fix expression
 * @author Akshat
 *
 */

public class InfixToPostfix 
{
StackImplementation stack = new StackImplementation();
	
	/*
	 *gives the precedence of operator 
	 * @param operator
	 * @return precedence 
	 */
	private int prec(String operator) 
	{ 
		switch (operator) 
		{

		case "=":
			return 1;
		case "||":
			return 2;
		case "&&":
			return 3;
		case "!":
			return 4;
		case "&":
			return 5;
		case "==":
		case "!=":
			return 6;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 7;
		case "+": 
		case "-": 
			return 8; 
		case "*": 
		case "/": 
			return 9; 
		case "^": 
			return 10; 
		} 
		return -1; 
	} 

	/*
	 *Converts the expression into post-fix expression  
	 * @param exp, string in array form
	 * @return post-fix expression in string
	 * @throws Exception
	 */
	private String evaluate(String[] exp) throws Exception {
		String postfix="";
		
		for(int index=0;index<exp.length;index++) 
		{
			String character = exp[index];
			
			//checking for the character or the number
			if(isElementNumeric(character) || isElementAlphabet(character)) {
				postfix+=character; }

			else if(character.equals("(")) 
				stack.push("("); 

			else if(character.equals(")")) 
			{ 
				while (!stack.isEmpty() && !(stack.top().equals("("))) 
					postfix += stack.pop(); 

				if (!stack.isEmpty() && !(stack.top().equals("("))) 
					throw new Exception("Invalid Exception");            
				else
					stack.pop(); 
			}

			//This case will execute when the operator is encountered
			else{ 

				while (!stack.isEmpty() && prec(character) <= prec(stack.top())) 
					postfix += stack.pop(); 
				stack.push(character); 
			} 
		}	
		
		//finally merging the left operator with the postfix expression
		while (stack.top!=stack.head) 
			postfix += stack.pop(); 
		return postfix;
	} 

	/*
	 * Checks for character is numeric or not
	 * @param element 
	 * @return true if numeric, false otherwise
	 */
	private boolean isElementNumeric(String element) {
		boolean result=false;
		for(int index=0;index<element.length();index++) {
			if(Character.isDigit(element.charAt(index)))
				result=true;
			else
				return result;
		}
		return result;
	}

	/*
	 * Checks for character is alphabet or not
	 * @param element 
	 * @return true if alphabet, false otherwise
	 */
	private boolean isElementAlphabet(String element) {
		boolean result=false;
		
		if(element.length()>1)
			return result;
		
		if(Character.isLetter(element.charAt(0)))
			result=true;
		else
			return result;
		
		return result;
	}
	
	/*
	 * Converts the infix expression to post fix expression
	 * @param input, infix expression
	 * @return converted post-fix expression
	 * @throws Exception
	 */
	public String convertToPostfix(String input) throws Exception
	{
		String result="";
		String array[] = new String[100];
		array = input.split(" ");
		result = evaluate(array);
		return result;
		
	}
	
	public static void main(String args[]) throws Exception
	{
		InfixToPostfix infixToPostfix= new InfixToPostfix();
		System.out.println(infixToPostfix.convertToPostfix("a + b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
	}
	

	
}
