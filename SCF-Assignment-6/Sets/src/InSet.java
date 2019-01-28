import java.util.ArrayList;

/**
 * Perform following Operations
 * 1. Size of set
 * 2. checks for the member of set
 * 3. Gives compliment of set
 * 4. Gives union of two sets
 * 5. Checks if one set is subset of another
 * @author Akshat Khandelwal
 */
public final class InSet {

	private int set[];
	
	/*
	 *parameterized constructor to initialize the data member
	 */
	
	public InSet(int []inputArray)
	{
		set= new int[inputArray.length];
		set=inputArray;
	}
	
	/*
	 * method to return size of set
	 * @param, does not requires any parameter
	 * returns the length of set
	 */
	
	public int size()
	{
		return set.length;
	}
	
	
	/*
	 *  helper method to return the private data member
	 *  @param, does not requires any parameter
	 *  returns the set in array form
	 */
	
	public int[] getSet()
	{
		return set;
	}
	
	/*
	 * method to check the member is present in set or not
	 * @param Integer type
	 * @return true if member present, false otherwise
	 */
	public boolean isMember(int memberElement)
	{
		boolean flg= false;
		
		try
		{
		for(int i=0;i<set.length;i++)
		{
			if(set[i]==memberElement)
			{
				flg=true;
			}
		}
		
		return flg;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	
	/*
	 * method to check for the subset of another set
	 * @param requires object of class IntSet
	 * @return true if subset, false otherwise
	 */
	
	
	public boolean isSubSet(InSet s ) 
	{
		int []subSet= s.getSet();
		
		boolean flg=false;
		int count=0;
		
		
		for(int i=0;i<subSet.length;i++)
		{
			for(int j=0;j<set.length;j++)
			{
				if(subSet[i]==set[j])
				{
					count++;
					
				}
			}
		}
		
		if(count == subSet.length)
			flg=true;
		
		return flg;
		
	}
	
	
	/*
	 *  method to get the complement of set
	 * assumes the universal set consist of integer values from 0 to 1000
	 * @returns the complement set
	 */
	
	
	
	public InSet getComplement()
	{
		int lengthOfUniversalSet=10;
		int complementArray[]= new int[lengthOfUniversalSet-set.length];
		 
		 int k=0,j=0;
		 for(int i=0;i<=lengthOfUniversalSet;i++)
		 {
			 if(k<set.length && set[k]==i)
             {
				k++; 
			 }
			 else
			 {
				 if(j<complementArray.length)
				 {
				 complementArray[j]=i;
				 j++;
				 }
			 }
		 }
		 
		
		 InSet complementSet= new InSet(complementArray);
		 return complementSet;
	}
	
	/*
	 * To compute the union set between two set
	 * @param reqiures two object of class IntSet
	 * @returns the union of two sets as InSet object
	 */
	
	public InSet union(InSet s1, InSet s2)
	{
		int []set1= s1.getSet();
		int []set2= s2.getSet();
		
		ArrayList<Integer> union= new ArrayList<Integer>();
		
		for(int i=0;i<set1.length;i++)
		{
			union.add(set1[i]);
		}
		
		boolean flg=false;
		for(int i=0; i<set2.length;i++)
		{
			
			for(int j=0;j<union.size();j++)
			{
				if(union.get(j)==set2[i])
				{
					flg=true;
				}
			}
			if(flg==false)
				union.add(set2[i]);
			flg=false;
		}
		
		
		int unionArray[]= new int[union.size()];

		
		for(int i=0;i<union.size();i++)
		{
			unionArray[i]=union.get(i);
		}

	
		
		InSet unionSet= new InSet(unionArray);
		 return unionSet;
	}
	
/*
 * Helper method to checks for equal of two sets
 * @param requires InSet object
 * returns true if equal,false otherwise
 */
	
	public boolean equals(InSet set1)
	{
		boolean flg= true;
			
		
		int[] array1=getSet();
		int [] array2=set1.getSet();
		
		
		
		int max;
		if(array1.length>array2.length)
			{
			flg=false;
			
		return flg;
			}
		
		if(array1.length<array2.length)
		{
		flg=false;
		
	return flg;
		}
		
		for(int i=0;i<array1.length;i++)
		{
			if(array1[i]!=array2[i])
			{
				flg=false;
			}
		}
		
		
		return flg;
	}
	
	
}
