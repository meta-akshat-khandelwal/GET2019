package Question3;
/**
 * 
 * @author Akshat
 *
 */
public interface Queue {
	//to add the data at the end of the list
		public void Enqueue(String data) throws Exception;
		
		//to delete the data from the start of the queue
		public String  Dequeue() throws Exception;
		
		//to check whether queue is empty or not
		public boolean isEmpty();
		
		//to check whether queue is full or not
		public boolean isFull();
		
		//to make the queue circular
		public void makeItCircular();
}
