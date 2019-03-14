package Question2;
/**
 * 
 * @author Akshat
 *
 */
public interface Stack {

	//To add the data into the stack
		public void push(String data);
		
		//to remove the top node of the stack
	    public String pop();
	    
	    //It will return the top data of the stack
	    public String top();

	    public boolean isEmpty();
	    
}
