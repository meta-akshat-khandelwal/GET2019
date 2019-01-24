/*
 * For Linear Search and Binary Search
 */
public class Search {
	
	/*
	 * method for  linear search 
	 *  @param inputArray holds the input of array 
	 *  @param number holds the number to  find
	 *  @param low holds the starting index of array
	 *  return the index+1 if found else -1 
	 */
	public int linearSearch(double[] inputArray , int index , double searchElement)
	{
		int arrayLength;
		try
		{
			arrayLength = returnLengthArray(inputArray);
			
			//index gets equal with array length the element is not present in array, then return -1
			if( index == arrayLength )
			{
				return -1;
			}
			
			//if searchElement gets found in the array the return the index of the element
			if( inputArray[index] == searchElement )
			{
				return index+1;
			}
			
			
			else 
			{
				return linearSearch(inputArray, index+1, searchElement);
			}
			
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		
	}
	
	/*
	 * returnLengthArray  to calculate the length of  array
	 * @param inputArray holds input array
	 * @return the length of  array 
	 */
	public int returnLengthArray(double[] inputArray)
	{
		
		int arrayLength = inputArray.length;
		
		if(arrayLength > 0)
		{
			return arrayLength;
		}
		
		else
		{
			throw new AssertionError();
		}
		
	}
   
   
   
/*
 * method for  binary search 
 * @param inputArray holds the input of array
 * @param low holds the starting index of array
 * @param high holds the last index of array
 * @param number holds the number to  find
 * return the index+1 if found else -1 
 */
   public int  binarySearch(double[] inputArray , int low , int high , double searchElement)
	{
		
		int lengthArray;
		
		try
		{
			
			lengthArray = returnLengthArray(inputArray);
			
			if(high >= low  && low >= 0)
			{
				
				int mid = (low + high) / 2;
				
				//check for the element to be at mid of an array
				if( inputArray[mid] == searchElement )
				{
					return mid+1;
				}
				
				//if searchElement is greater then it should be present in the right side of the array
				if( inputArray[mid] < searchElement )
				{
					return binarySearch(inputArray, mid+1, high, searchElement);
				}
				
				
				 // else then searchElement should be present in the  left side of the array
				  
				 
				else
				{
					return binarySearch(inputArray, low, mid-1, searchElement);
				}
				
			}
			
			//if element is not found in the array then , will return -1
			else
			{
				return -1;
			}
			
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
		
		
		
	}
	
	

}
