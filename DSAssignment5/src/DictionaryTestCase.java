import static org.junit.Assert.*;

/**Test class for dictionary
 * @author Akshat
 */
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;


public class DictionaryTestCase {
Dictionary dictionary;
	
	//initialize the tree with the data from JSON file
	@Before
	public void initializeAddDataToTree() throws Exception
	{
		JSONObject json = null;
		JSONParser parser = new JSONParser();
	    try 
	    {
	        json = (JSONObject) parser.parse(new FileReader("Input.json"));
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
	    dictionary = new DictionaryImp(json);
	}
	

	
	//Negative test case of adding the node with existing key
	@Test(expected = Exception.class)
	public void test_addWithValidInputShouldThrowExceptionOfKeyAlreadyExists() throws Exception
	{
		dictionary.add("100", "Hundred");
	}
	
	//Positive test case of deleting the data
	@Test
	public boolean test_deleteNodeWithvalidInputShouldReturnFalse() 
	{
		try{
			
		assertTrue(dictionary.delete("200"));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	//negative test case of deleting the node with key that doesn't exist
	@Test(expected = Exception.class)
	public void test_deleteNodeWithvalidInputShouldThrowError() throws Exception
	{
		dictionary.delete("1000");
	}
	
	
	
	//Positive test case to get the sublist from the tree
	@Test
	public boolean test_getSortedKeyValueBetweenKeysWithValidInputShouldreturnValidList()
	{
		try{
		
		for(Data d : dictionary.getSortedKeyValueBetweenKeys("200", "300"))
		{
			System.out.println(d.getKey()+"  "+d.getValue());
			
		}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
	//positive test case to get the value of given key
	@Test
	public boolean test_getValueWithvalidInputShouldReturnValue()
	{
		try{
			
		assertEquals("Four Hundred", dictionary.getValue("400"));
		}
		catch(Exception e)
		{
			return false;
		}	
	}
	
	//Negative test case of getting the value where key is null
	@Test(expected = Exception.class)
	public void test_getValueWithvalidInputShouldThrowError() throws Exception
	{
		dictionary.getValue("");
	}
	

}
