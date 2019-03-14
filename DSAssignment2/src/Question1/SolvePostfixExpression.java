package Question1;
/**
 * Solves the Postfix expression
 * @author Akshat
 *
 */
public class SolvePostfixExpression {

	
Stack stack = new StackImplementation();
	
	/*
	 *Evaluates postfix expression
	 * @param expression
	 * @return, result of expression
	 * @throws Exception if expression is not valid
	 */
    public int evaluate(String expression) throws Exception 
    {	
    	
    	if(expression == null )
    		return 0;
    	
    	//loop to iterate over the expression given as input
        for(int i=0;i<expression.length();i++) 
        {
        	char c = expression.charAt(i); 
            
            if(c == ' ') 
            continue; 
              
            // if character is digit
            else if(Character.isDigit(c)) 
            { 
                int num = 0; 
                  
                //extract the characters and store it in num 
                while(Character.isDigit(c)) 
                { 
                    num = num*10 + (int)(c-'0'); 
                    i++; 
                    c = expression.charAt(i); 
                } 
                i--; 
  
                //push the number in stack 
                stack.push(num); 
            } 
            else 
            {
                int value1 = stack.pop();
                int value2 = stack.pop();

                switch(c) 
                {

                case '+': 
                    stack.push(value2+value1); 
                    break; 

                case '-': 
                    stack.push(value2-value1); 
                    break; 

                case '/': 
                    stack.push(value2/value1); 
                    break; 

                case '*': 
                    stack.push(value2*value1); 
                    break; 

                default:
                    throw new Exception("Wrong Expression");
               }
            }
        }
        
        return stack.pop(); 
    }
    
    
    
    public static void main(String[] args)  throws Exception
    { 
    	
    	SolvePostfixExpression solvePostfixExpression= new SolvePostfixExpression();
        String exp = "100 200 + 2 / 5 * 7 +"; 
        System.out.println(solvePostfixExpression.evaluate(exp)); 
    } 
}
