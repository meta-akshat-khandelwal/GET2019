package Question2;
/**
 * Stack Implementation
 * @author Akshat
 *
 */
public class StackImplementation implements Stack {

	
	  Node head,top;
	     
	     /**
		  * add element to stack
		  * @param data
		  */ 
	    @Override
	    public void push(String data) 
	    {
	        Node node =new Node(data);
	        if(isEmpty()) 
	        {
	            head=node;  
	            top=node;
	        }
	        else 
	        {
	            node.setNext(top);
	            top=node;
	        }
	    }

	    /*
		 * gives and removes the top element of from stack
		 * @return remove element
		 */
	    @Override
	    public String pop() 
	    {
	    	String data=top.data;
	        top=top.next;
	        return data;
	    }

	    /*
		 * gives top element of stack
		 * @return top element
		 */
	    @Override
	    public String top() 
	    {
	        return top.data;
	    }

	    /*
	     *Checks for stack is empty or not
	     * @return true if stack is empty, false otherwise
	     */
		@Override
		public boolean isEmpty() 
		{
			if(head == null)
				return true;
			return false;
		}
}
