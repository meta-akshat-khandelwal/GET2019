package Question4;

public class QueueImplementation implements Queue{

	
	Node front,rear;

/*
 *adds element in queue
 *@param, data 
 */
    @Override
    public void Enqueue(String data) {
        Node node =new Node(data);
        if(front==null) {
            front=node;  
            rear=node;
        }
        else {
            rear.setNext(node);
            rear=node;
        }
    }

    /*
     *Removes the element from queue
     *@return, element 
     */
    @Override
    public String Dequeue() {
        if(front==rear) {
            String data=front.data;
            front=null;
            rear=null;
            return data;
        }
        String data=front.data;
        front=front.next;
        return data;
    }

    /*
     *Checks for queue is empty
     *@return true if empty , false otherwise 
     */
    @Override
    public boolean isEmpty() {

        if(rear==null) 
            return true; 
        else 
            return false;        
    }
	
}
