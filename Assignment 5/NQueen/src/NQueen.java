/*
* For implementation of N Queen problem with random row input to start 
*/

public class NQueen {

	/*
	* method for check given place is right or not for queen
	* return false if place is not correct
	*/
	boolean isValid(int[][] array,int row,int col)
	{
		//size of array for max condition of loop
		int size = array[0].length;

		//loop for check the upper side row to queen if found return false
		for(int count=row;count>=0;count--)
			if(array[count][col]==1)
				return false;
		
		//loop for check the down side row for queen if found return false
		for(int count=row;count<size;count++)
			if(array[count][col]==1)
				return false;
			
		//loop for check left upper diagonal for queen if found return false
		for(int count=row,count2=col;count>=0 && count2>=0;count--,count2--)
			if(array[count][count2] == 1)
				return false;
		
		//loop for check left down diagonal for queen if found return false
		for(int count=row,count2=col;count<size && count2>=0;count++,count2--)
			if(array[count][count2] == 1)
				return false;

		//loop for check right upper diagonal for queen if found return false
		for(int count=row,count2=col;count>=0 && count2<size;count--,count2++)
			if(array[count][count2]==1)
				return false;
		
		//loop for check right down diagonal for queen if found return false
		for(int count=row,count2=col;count<size && count2<size;count++,count2++)
			if(array[count][count2]==1)
				return false;
		
		return true;
	}
	
	
	boolean solveQueen(int[][] array, int startRow,int queen)
	{
		//return if all queen is placed
		if(queen==0)
			return true;

		int size = array[0].length;

		/*loop for selecting one row and increasing the column size
		* for check place for queen
		*/
		for(int col = 0;col<size;col++)
		{
			
			// method for check given place is right or not
	
			if(isValid(array,startRow,col))
			{
				array[startRow][col] = 1;
				queen = queen- 1;
				if(startRow==size-1)
					startRow = -1;

				 //recursive function that call itself with next row value
		
				if(solveQueen(array, startRow+1,queen))
					return true;
				
				if(startRow<=-1)
					startRow = size-1;
				
				/*
				* backtracking if its not a true condition for queen it remove the previous 
				* queen
				*/
				array[startRow][col] = 0;
				queen = queen+ 1;
			}
		}
		
		// return false is not solution found
		return false;
	}
	
	
}
