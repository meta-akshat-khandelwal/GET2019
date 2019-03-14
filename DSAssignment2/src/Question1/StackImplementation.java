package Question1;
/*
 * Stack implementation 
 * @author Akshat
 *
 */
public class StackImplementation implements Stack {

	
	
	 Node head,top;
	  
	  /*
	   * to add data in stack
	   * @param data
	   */
	  @Override
	  public void push(int data) 
	  {
	     Node node =new Node(data);
	     if(head==null) 
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
	   * return and deletes the top data form stack
	   * @return removing data
	   */
	  @Override
	  public int pop() 
	  {
	     int data=top.data;
	     top=top.next;
	     return data;
	  }

	  /*
	   * gives the top element in stack
	   * @return the top data of the stack
	   */
	  @Override
	  public int top() 
	  {
	     return top.data;
	  }
}
