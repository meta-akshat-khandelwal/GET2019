package Question1;

import static org.junit.Assert.*;



import org.junit.Test;

public class linkListTest {

	//test case to add data into the linked list
	@Test
	public void testAddData()
	{
		LinkList linkList = new LinkList();
		linkList.addData(2);
	}
	
	//Negative test case with invalid input to rotate the list
	@Test
	public void testRotateWithWrongCoordinates()
	{
		LinkList linkedList =new LinkList();
		linkedList.addData(1);
		linkedList.addData(2);
		linkedList.addData(3);
		linkedList.addData(4);
		linkedList.addData(5);
		try 
		{
			linkedList.rotateList(-1, 3, 2);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	//test case to rotate the linked list with the given coordinates
	@Test
	public void testRotateWithValidCoordinates()
	{
		
		LinkList linkedList =new LinkList();
		linkedList.addData(1);
		linkedList.addData(2);
		linkedList.addData(3);
		linkedList.addData(4);
		linkedList.addData(5);
		linkedList.addData(6);
		linkedList.addData(7);
		try 
		{
			linkedList.rotateList(1, 7, 1);
			Node node = linkedList.getHead();
			while(node!=null)
			{
				System.out.println(node.getData());
				node = node.getNext();
			}
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	//test case to detect loop in the linked list
	@Test
	public void testDetectLoop()
	{
		LinkList linkedList =new LinkList();
		linkedList.addData(1);
		linkedList.addData(2);
		linkedList.addData(3);
		linkedList.addData(4);
		linkedList.addData(5);
		linkedList.addData(6);
		linkedList.addData(7);
		assertFalse(linkedList.detectLoop());
	}
}
