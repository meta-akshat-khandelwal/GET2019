package Question1;
/**
 * Linked List with its operations
 * @author Akshat
 *
 */

public class LinkList {

	Node head;
	int size;
	
	public LinkList()
	{
		head = null;
	}
	
	
	/*
	* checks if list is empty or not
	* @return true if empty, false otherwise
	*/
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	
	/*
	 * add data in list
	 * @param data to be added
	 */
	public void addData(int data)
	{
		Node node = new Node(data);
		node.setNext(null);
		if(isEmpty())
		{
			head = node;
			size+=1;
		}
		else
		{
			Node current=head;
			Node prev=null;
			while(current!=null)
			{
				prev = current;
				current = current.getNext();
			}
			prev.setNext(node);
			current = node;
			size+=1;
		}
		
	}
	
	/*
	 * helper method to rotate a list 
	 * @param round
	 * @param list
	 * @return  rotated list
	 */
	 private LinkList rotate(int round,LinkList list) 
	    { 
	        if (round == 0) return list; 
	  
	        Node current  = list.head; 
	  
	        int count = 1; 
	        while (count < round && current !=  null) 
	        { 
	            current = current.getNext(); 
	            count++; 
	        } 
	  
	        if (current == null) 
	            return list; 
	  
	        Node kthNode = current; 
	        while (current.getNext() != null) 
	            current = current.getNext(); 
	  
	        current.setNext(list.head); 
	        list.head = kthNode.getNext(); 
	        kthNode.setNext(null); 
	        return list;
	  
	    } 

	    /*
	     * rotates a list clock wise direction
	     * @param left
	     * @param right
	     * @param noOfTimes
	     * @throws Exception 
	     */
	    public void rotateList(int left,int right,int roundNumber) throws Exception
	    {
	    	int subSize = right - left +1;
	    	if(left > right || left < 1 || right > size)
	    	{
	    		throw new Exception("Invalid Input");
	    	}
	    	
	    	if(roundNumber > subSize)
	    	{
	    		roundNumber = roundNumber % subSize;
	    	}
	    	
	    	LinkList listOne = new LinkList();
	    	LinkList listTwo = new LinkList();
	    	Node current = head;
	    	int start=1;
	    	while(start<left)
	    	{
	    		listOne.addData(current.getData());
	    		current = current.getNext();
	    		start++;
	    	}
	    	
	    	while(start<=right)
	    	{
	    		listTwo.addData(current.getData());
	    		current = current.getNext();
	    		start++;
	    	}
	    	
	    	listTwo = rotate(roundNumber, listTwo);
	    	
	    	Node node = listTwo.head;
	    	while(node != null)
	    	{
	    		listOne.addData(node.getData());
	    		node = node.getNext();
	    	}
	    	while(current!=null)
	    	{
	    		listOne.addData(current.getData());
	    		current = current.getNext();
	    	}
	    	head = listOne.head;	    	
	    }
	
	/*
	 * to detect loop in list
	 * @param
	 * @return true if loop is present, false otherwise  
	 */
	public boolean detectLoop()
	{
		Node start, end;
		start  = head;
		end =head.getNext();
		while(end!=null)
		{			
			if(end.getNext()!=null)
			{
				end = end.getNext().getNext();
				start = start.getNext();
				if(start == end)
					return true;
			}
		}
		return false;
	}
	
	/*
	 * to get head of list 
	 * @return head of list
	 */
	public Node getHead()
	{
		return this.head;
	}
	
}
