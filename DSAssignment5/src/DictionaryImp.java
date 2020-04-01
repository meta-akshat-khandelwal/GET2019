import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Dictionary implementation and reads data in json form
 * @author Akshat
 *
 */

public class DictionaryImp implements Dictionary {

	
	BinarySearchTree binarySearchTree = new BSTImplementation();
	
	
	
	@SuppressWarnings("unchecked")
	public DictionaryImp(JSONObject jsonObject) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		// to reads data form json file
		try 
		{
			data = new ObjectMapper().readValue(jsonObject.toString(),HashMap.class);
		}
		catch (IOException e) 
		{
			throw e;
		}
		
		for(String key : data.keySet())
		{
			add(key, data.get(key));
		}
		
	}
	
	/*
	 * add key value to dictionary
	 * @param key
	 * @param value
	 * @return true if added, false otherwise 
	 * @throws error of key or value not null
	 */
	@Override
	public boolean add(String key, String value) throws Exception 
	{
		if(key == null || value == null)
			throw new Exception("Key or value cannot be null");
		return binarySearchTree.insert(key, value);
		
	}

	/*
	 * to delete the key value pair from dictionary
	 * @param key 
	 * @return true of node is deleted, false otherwise
	 * @throws error of key cannot be null 
	 */
	@Override
	public boolean delete(String key) throws Exception 
	{
		if(key == null)
			throw new Exception("Key cannot be null");
		return binarySearchTree.delete(key);
	}

	/*
	 * to get the value corresponding to key
	 * @param key
	 * @return value 
	 * @throws error of key cannot be null 
	 */
	@Override
	public String getValue(String key) throws Exception
	{
		if(key == null)
			throw new Exception("key cannot be null");
		return binarySearchTree.findValue(key);
	}

	/*
	 * get  list of key value from the tree
	 * @return the list
	 * @throws error if tree is null
	 */
	@Override
	public List<Data> getSortedKeyValue() throws Exception 
	{
		return binarySearchTree.getAll();
	}
	
	/*
	 * find the nodes in between two keys
	 * @param key1
	 * @param key2
	 * @return list of nodes
	 * @throws error if tree is empty or key is empty
	 */
	@Override
	public List<Data> getSortedKeyValueBetweenKeys(String key1, String key2) throws Exception
	{
		if(key1 == null || key2 == null)
			throw new Exception("Input cannot be null");
		return binarySearchTree.getBetweenKeys(key1, key2);
	}
	
	
	
}
