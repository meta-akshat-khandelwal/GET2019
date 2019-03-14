package Question3;
/**
 * @author Akshat
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTestCase {
	
	// test case for is empty method of queue
	@Test
	public void testQueueWithValidInputShouldReturnFalse() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.Enqueue("1");
		queue.Enqueue("2");
		assertFalse(queue.isEmpty());
		assertFalse(queue.isFull());
	}
	
	
	
	// test case for is full method of queue
	@Test
	public void testQueue_isFullWithValidInput_ShouldReturnFalse() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.Enqueue("1");
		queue.Enqueue("2");
		queue.Dequeue();
		
		assertFalse(queue.isFull());
		
	}
	
	
	
	
	@Test(expected = Exception.class)
	public void testQueueyWithValidInput_ShouldThrowError() throws Exception
	{
		Queue queue = new QueueImplementation();
		for(int i=0;i<100;i++)
		{
			queue.Enqueue(""+i);
		}
		queue.Enqueue("100");
	}
	
	

}
