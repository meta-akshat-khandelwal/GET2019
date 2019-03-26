package Question3;

public class LinkedList {

	private Node head;
	
	//constructor to initialize the linked list with null
	public LinkedList()
	{
		head=null;
	}
	
	/**
	 * to add the data into the linked list
	 * @param data to be added into the list
	 */
	public void add(Object data)
	{
		Node node = new Node(data);
		if(isEmpty())
		{
			head = node;
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
			
		}
	}
	
	/**
	 * to get the head of the linked list
	 * @return the head of the linked list
	 */
	public Node getHead()
	{
		return this.head;
	}
	
	/**
	 * to check whether linked list is empty or not
	 * @return true if list is empty or false if not
	 */
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	
}
