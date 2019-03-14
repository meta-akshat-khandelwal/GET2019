package Question1;
/**
 * 
 * @author Akshat
 *
 */
public class Node {

	int data;
    Node next;
    
    
    public Node(int data) {
        this.data=data;
        this.next=null;
    }

   
    public int getData() {
        return this.data;
    }

    
    public Node getNext() {
        return this.next;
    }

   
    public void setNext(Node node) {
        this.next=node;
    }
	
	
	
}
