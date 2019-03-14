package Question3;
/**
 * Queue Implementation using array
 * @author Akshat
 *
 */


public class QueueImplementation implements Queue{

	int front=0;
	int rear=-1;
	int SIZE = 10;
	boolean circular_flag=false;
	String[] queue = new String[SIZE];
	
	
	/*
	 * adds element in queue
	 * @param, data to store in queue
	 * @throws exception 
	 */
	@Override
	public void Enqueue(String data) throws Exception {
		if(circular_flag) {
			if(rear==SIZE-1)
				rear=0;
		}
		if(!isFull())
		{
			rear+=1;
			queue[rear]=data;
			
		}
		else
			throw new Exception("Queue is Full");
	}

	/*
	 *remove element in queue
	 *@return element  
	 */
	@Override
	public String Dequeue() throws Exception {
		if(circular_flag)
		{
			if(front == SIZE-1)
				front=0;
		}
		if(!isEmpty())
		{
			return queue[front++];
		}
		else
			throw new Exception("Queue is Empty");
		
	}

	/*Checks for Queue is empty or not
	 * @returns true if empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if(rear == front )
			return true;
		return false;
	}

	/*Checks for Queue is full or not
	 * @returns true if full, false otherwise
	 */
	@Override
	public boolean isFull() {
		if(circular_flag)
		{
			if(rear==front-1)
				return true;
			return false;
		}
		if(rear == SIZE-1)
		{
			return true;
		}
		return false;
	}

	/*
	 *Makes the Queue circular 
	 */
	@Override
	public void makeItCircular() {
		circular_flag=true;
	}	
	
	
	public static void main(String args[]) 
	{
		QueueImplementation queueImplementation= new QueueImplementation();
		
		try {
			for(int i=0;i<10;i++)
			{
				queueImplementation.Enqueue(""+i);
				System.out.println(queueImplementation.queue[i]);

			}
			System.out.println(queueImplementation.Dequeue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(queueImplementation.isEmpty());
	}
}
