package Question3;

public class Node {

	
	private Object object;	
	private Node next;
	
	//constructor to initialize the properties of node 
	public Node(Object object)
	{
		this.object = object;
		this.next=null;
	}
	
	//returns the data of the node
	public Object getData()
	{
		return this.object;
	}
	
	//returns the next location of the node
	public Node getNext()
	{
		return this.next;
	}
	
	//sets the next location of the node
	public void setNext(Node next)
	{
		this.next = next;
	}
}
