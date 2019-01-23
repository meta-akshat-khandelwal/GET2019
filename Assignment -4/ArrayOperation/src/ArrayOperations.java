import java.util.ArrayList;


public class ArrayOperations {

	
	/*
	 * checkEqual method to check the equal value of x and y
	 * @param array contain array
	 * @param numX number of x present in array
	 * @param numY number of y present in array
	 * return true if numX == numY
	 */
	boolean checkEqual(int[] array,int x,int y)
	{
		int numX = 0;
		int numY = 0;
		
		try{
			for(int index = 0;index<array.length;index++)
			{
				if(array[index]==x)
					numX++;
				if(array[index]==y)
					numY++;
			}
			if(numX==numY)
				return true;
			else
				throw new AssertionError();
		}
		catch(AssertionError assertion)
		{
			throw assertion;
		}
		
	
	}
	
	/*
	 * checkLastIndex method to check the last index array element
	 * @param array contain array value
	 * return true if last index value is x
	 */
	boolean checkLastIndex(int[] array,int x)
	{
		try
		{
			if(array[array.length-1]==x)
				throw new AssertionError();
		}
		catch(AssertionError assertion)
		{
			throw assertion;
		}
		
		return true;
	
	}
	
	
	/*
	 * adjacentX method to check two adjacent value of x
	 * @param array contain array value
	 * return true if two adjacent value of x present
	 */
	boolean adjacentX(int[] array,int x)
	{
		try
		{
			for(int index=0;index<array.length-1;index++)
				if(array[index]==x && array[index+1]==x)
					throw new AssertionError();
			
		}
		catch(AssertionError  assertion )
		{
			throw assertion;
		}
	
		return true;
	}
	
	/*
	 * returnLengthArray method is used to compute the length of the input array
	 * @param requires an array of integers, assumes array is of integer type
	 * @return the length of array if array is not null, otherwise will throw an exception
	 */
	public int returnLengthArray(int[] inputArray)
	{
		int lengthArray=inputArray.length;
		
		if(lengthArray == 0)
		{
			throw new AssertionError();
		}
		
		else 
			return lengthArray;
	}
	
	/*
	 * maximumMirrorCount method is used to find the sub-array which is mirror image of already present sub-array
	 * @param requires the input array of integer, will throw an exception if array is null, assumes input is array of positive integers
	 * @return the length of array whose mirror image is available else will return the exception
	 */
	
	public int maximumMirrorCount(int[] inputArray)
	{
		
		int maxLength,index1,index2,tempIndex1,tempLength,length;
		
		maxLength = tempLength = 0;
		
		try
		{
			length = returnLengthArray(inputArray);
			
			for(index1 = 0 ; index1 < length ; index1++)
			{
				//assign the index for second loop comparison and manipulation will be done on this only 
				tempIndex1 = index1;	
				
				for(index2 = length-1 ; index2 >= 0 ; index2--)
				{
					
					if(tempIndex1 < length && inputArray[tempIndex1] == inputArray[index2])
					{
						tempLength++;
						tempIndex1++;
					}
					
					else
					{
						
						if(maxLength < tempLength)
						{
							maxLength = tempLength;
							tempLength = 0;
						}
						
						tempLength = 0;
					}
					
				}
				
			}
			
			return maxLength;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
				
	}
	
	/*
	 * splitArray method to find the index where the sum of left side and right side is equal
	 * @param requires the array if integers ,will throw an exception if array is empty ,assumes input is array of positive integers
	 * @return the index where the sum of left and right side is equal or will return an exception or if sum is not equal in any case then will return -1 
	 */
	public int splitArray(int[] inputArray)
	{
		
		int leftSum,rightSum,index,leftLoop,rightLoop,length;
		
		try
		{
			length = returnLengthArray(inputArray);
			for(index = 0 ; index < length ; index++)
			{
				
				leftSum = 0;
				rightSum = 0;
				
				//loop to calculate the sum of left array
				for(leftLoop = 0 ; leftLoop < index ; leftLoop++)
				{
					leftSum = leftSum + inputArray[leftLoop];
				}
				
				//loop to calculate the sum of right array
				for(rightLoop = index ; rightLoop < length ; rightLoop++)
				{
					rightSum = rightSum + inputArray[rightLoop];
				}
				
				if (leftSum == rightSum) 
				{
					return index;
				}
				
			}
			
			return -1;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
					
	}
	
	/*
	 * countClumbs method is use to find the number of clumbs which have a series of 2 or more adjacent elements of the same value
	 * @param requires an array of integer type, will throw an exception if array is empty ,assumes input is array of positive integers
	 * @return the number of clumb 0 if any clumb is not present or will return the number of clumbs
	 */
	public int countClumbs(int[] inputArray)
	{
		
		int clumbCount=0,length;
		int currentvalue,previousvalue;
		
		try
		{
			length = returnLengthArray(inputArray);
			
			int size=1;
			previousvalue=inputArray[0];
			
			for(int i=1;i<inputArray.length;i++)
			{
				currentvalue=inputArray[i];
				
				if(previousvalue == currentvalue)
				{
					size++;
				}
				
				if(previousvalue != currentvalue || i==inputArray.length-1)
				{
					
					if(size>=2)
					{
						clumbCount++;
						size=1;
					}
				}
				previousvalue=currentvalue;
				
			}
			
			
			
			return clumbCount;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
				
	}
	
	/*
	 * fitXY will change the position of Y after the value of X without changing the position of X
	 * @param requires the array of Integer assumes array is of integer type,
	 * 		  valueOfX, valueOfY, which will hold the value of X and Y
	 *        it will throw an exception an exception in the following cases:
	 *        1: if array is empty
	 *        2: if two consecutive value of X is present in an array
	 *        3: it value of X is present at the last index of array
	 *        4: if total number of X is not equal to total number of Y
	 * @return an array of integer with the modification as stated.
	 */
	
public 	int[] fixXY(int[] array,int x,int y)
	{
		
		int lengthArray = 0;
	
		try
		{
			lengthArray = this.returnLengthArray(array);
			this.adjacentX(array, x);
			this.checkEqual(array, x, y);
			this.checkLastIndex(array, x);
			
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			throw exception;
		}
		
	
		ArrayList<Integer> indexX= new ArrayList<Integer>(); 
		ArrayList<Integer> indexY= new ArrayList<Integer>();
		
		
		int j=0;
		while(j<array.length)
		{    
			//store index of x  in arrayList indexX
			if(array[j]==x)
			{
				indexX.add(j);
			}
			
			//store index of y  in arrayList indexY
			if(array[j]==y)
			{
				indexY.add(j);
			}
			j++;
		}
		
		
		int countX=0, countY=0;
		int temp;
		
		System.out.println("\n");
		for(int i=0;i<array.length-1;i++)
		{	
		
			if(indexX.get(countX)==i)
			{
				temp=array[indexY.get(countY)];
				array[indexY.get(countY)]=array[i+1];
				array[i+1]=temp;
				i=i+1;
				
				
				countX++;
				countY++;
			}
			
		}
		
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		
		return array;
		
	}
	
	
	
}
