package Question2;
/**Counts the no. of Unique characters in string
 * @author Akshat
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NumberOfUniqueCharacter {

	// Hash map used as cache for repeated string 
	HashMap<String, Integer> cache= new HashMap<>();

	/**
	 * counts the no. of unique characters in string
	 * @param input
	 * @return, no. of unique characters
	 */
	public int countsNmberOfUniqueCharacters(String input)
	{
		int result=0;
		
		// checks for string in cache hash-map
		if(cache.containsKey(input))
		{
			result = cache.get(input);
			return result;
		}
		
		
	HashMap<Character, Integer> uniquecharacter= new HashMap<>();
		
		for(int i=0;i<input.length();i++)
			{
			// takes single character from input string
				char tempChar= input.charAt(i);
				
				// checks for character is already present in uniquecharacter hash-map
				if(uniquecharacter.containsKey(tempChar))
				{
					int count= uniquecharacter.get(tempChar);
					uniquecharacter.put(tempChar,count+1);
				}
				
				else
					uniquecharacter.put(tempChar, 1);
				
			}
		
			// Retrieves the keys of uniquecharacter hash map as set
		 	Set<Character> keyset= uniquecharacter.keySet();
		
		 	
		
		Iterator<Character> iterator = keyset.iterator(); 

		while(iterator.hasNext())
		{	
			// counts the no. characters with single occurrence in string as stored in uniquecharacter map
			if(uniquecharacter.get(iterator.next()) == 1 )
				result ++;
		}
		
		// puts the string with no. of unique characters in cache hash-map
		cache.put(input, result);
		return result;
	}
	
	
	public static void main(String args[])
	{
		NumberOfUniqueCharacter nu= new NumberOfUniqueCharacter();
		int value=nu.countsNmberOfUniqueCharacters("aqwe@#$qwea@#");
		System.out.println(value);
		System.out.println(nu.countsNmberOfUniqueCharacters("Aqwe@#$qwea@#"));
			
	}
	
	
}
