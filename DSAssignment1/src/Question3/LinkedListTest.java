package Question3;

import static org.junit.Assert.*;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
NestedList nestedListImpl;
	
	//to initialize the constructor with the JSON array 
	@Before
	public void testBefore() throws Exception
	{
		JSONArray json = null;
		JSONParser parser = new JSONParser();
	    try 
	    {
	        json = (JSONArray) parser.parse(new FileReader("input.json"));
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
		
		nestedListImpl = new NestedList(json);
	}
	
	//to get the sum of whole list
	@Test
	public void testSumOfListWithValidInputShouldReturnSum()
	{
		assertEquals(190, nestedListImpl.getSum(),0);
	}
	
	// to search the value from the list
	@Test
	public void testSearchValueWithValidInputShouldReturnTrue()
	{
		assertEquals(true, nestedListImpl.isValueAvailable(2));
	}
	
	// to search the value in the list
	@Test
	public void testSearchValueWithValidInputShouldReturnFalse()
	{
		assertEquals(false, nestedListImpl.isValueAvailable(20));
	}
	
	// to get the maximum value from the list
	@Test
	public void getLargestValue()
	{
		assertEquals(19, nestedListImpl.getMaxValue(),0);
	}
}
