package Question3;
/**
 * Calculates the molecular mass of organic compound
 * @author Akshat
 */
import java.util.HashMap;


public class CalculateMass {

HashMap<Character, Integer> elementMass = new HashMap<Character, Integer>();
	
/**
 * adds elements in the element mass hash-map
 */
	public CalculateMass()
	{
		elementMass.put('C', 12);
		elementMass.put('H', 1);
		elementMass.put('O', 16);
	}
	
 
	/**
	 * updates the compound and temporary map 
	 * @param tempChar, key for map
	 * @param factor,  value or no. of atoms corresponding to element
	 * @param map, Map in which element has to be added
	 * @throws Exception
	 */
	private void updateMap(char tempChar, int factor, HashMap<Character, Integer> map) throws Exception
	{
		// checks if element exists in the organic element map
		if(elementMass.containsKey(tempChar))
		{
			// checks if map already contains that element
			if(map.containsKey(tempChar))
			{
				int value = map.get(tempChar);
				map.put(tempChar, value+factor);
			}
			else
			{
				map.put(tempChar, factor);
			}
		}
		else
		{
			throw new Exception("Element "+tempChar+" Doesn't Exist");
		}
	}
	
	
	/**
	 * Converts the input string into map of organic compound
	 * @param input, chemical formula
	 * @return, map of compound
	 * @throws Exception
	 */
	private HashMap<Character, Integer> convertToMap(String input) throws Exception
	{
		int index=0,j,factor;
		boolean flag = false;
		HashMap<Character, Integer> compound = new HashMap<Character, Integer>();
		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
		
		// converts the string into map
		while(index < input.length())
		{
			factor=1;
			char tempChar = input.charAt(index);
			j=index+1;
			
			if(j<input.length())
			{
				char tempNext = input.charAt(j);
				if(Character.isDigit(tempNext))
				{
					factor = Character.getNumericValue(tempNext);
				}
			}
			
			// checks for starting of bracket in formula of compound
			if(tempChar == '(')
			{
				flag=true;
				index++;
				continue;
			}
			
			// checks for ending of bracket in formula of compound
			if(tempChar == ')')
			{
				flag=false;
				if(factor>1)
				{
					for(char c : temp.keySet())
					{
						temp.put(c, temp.get(c)*factor);
					}
					index=index+2;
				}
				else
				{
					index++;
				}
				merge(compound,temp);
				continue;
			}
			
			// converts the compound into map
			if(!flag)
			{
				updateMap(tempChar, factor, compound);
				if(factor == 1)
				{
					index++;
				}
				else
				{
					index=index+2;
				}
				continue;
			}
			
			// converts the compound in brackets into temporary map
			if(flag)
			{
				updateMap(tempChar, factor, temp);
				if(factor == 1)
				{
					index++;
				}
				else
				{
					index=index+2;
				}
			}
			
		}
		
		
		return compound;
	}
	
	/**
	 * Merges the temporary and compound maps
	 * @param compound
	 * @param temp
	 */
	private void merge(HashMap<Character, Integer> compound,  HashMap<Character, Integer> temp)
	{
		for(char tempChar : temp.keySet())
		{
			if(compound.containsKey(tempChar))
			{
				compound.put(tempChar, compound.get(tempChar)+temp.get(tempChar));
			}
			else
			{
				compound.put(tempChar, temp.get(tempChar));
			}
		}
		temp.clear();
	}
	
	/**
	 * calculates the molecular mass of organic compound
	 * @param input
	 * @return mass of compound
	 * @throws Exception
	 */
	public int calculateMolecularMass(String input) throws Exception
	{
		input= input.toUpperCase();
		int mass = 0;
		HashMap<Character, Integer> compound = convertToMap(input);
		
		
		for(Character c : compound.keySet())
		{
			if(compound.get(c)>0)
			{	
				mass = mass + elementMass.get(c)*compound.get(c);
			}
		}
		
		return mass;
	}


	public static void main(String args[])
	{
		CalculateMass calculateMass= new CalculateMass();
		try{
			System.out.println(calculateMass.calculateMolecularMass("CH4"));
			
			System.out.println(calculateMass.calculateMolecularMass("CHO(CH3O)2C"));
			
			System.out.println(calculateMass.calculateMolecularMass("CH(CH3)3OA"));
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
}
