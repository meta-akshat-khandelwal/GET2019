import java.util.ArrayList;
/**
 * Performs the following Operations
 * 1. Transpose of Sparse matrix
 * 2. Checks for symmetry of matrix
 * 3. Addition of two Sparse matrix
 * 4. Multiplication of two sparse matrix
 *  @author akshat khandelwal
 **/

public class SparseMatrix {
 
 private  int [][] matrix;
 private int row;
 private int col;
 public SparseMatrix(int [][]inputArray)
 {
	 int length=0;
	 
	 for(int i=0;i<inputArray.length;i++)
	 {
		 for(int j=0;j<inputArray[i].length;j++)
		 {
			 if(inputArray[i][j]!=0)
				 length++;
		 }
	 }
	 
	 row=inputArray.length;
	 col=inputArray[0].length;
			 
	 matrix= new int[length][3];
	 int a=0;
	 for(int i=0;i<inputArray.length;i++)
	 {
		 for(int j=0;j<inputArray[i].length;j++)
		 {
			 if(inputArray[i][j]!=0)
			 {
				matrix[a][0]=i;
				 matrix[a][1]=j;
				 matrix[a][2]=inputArray[i][j];
				 a++;
			 }
		 }
	 }
	 
 }

 /*
  * Transpose any sparse matrix
  * @param, an SparseMatrix 
  * @return transpose as sparse matrix
  */
 public SparseMatrix getTranspose(SparseMatrix s)
 {
	 int transposeArray[][]= helperTranspose(s);
	 
	 //convert transpose matrix into normal matrix form
	 int result[][]=toMatrix(transposeArray,s.row,s.col);
	 SparseMatrix answer= new SparseMatrix(result);
	 return answer;
 }
 
 /*
  * Transpose any SparseMatrix object
  * @param, an SparseMatrix object
  * @return 2d array as row, column and value
  */
 private  int[][] helperTranspose( SparseMatrix s)
 {
	 int inputArray[][]= new int[s.matrix.length][3];
	 
	
		 for(int j=0;j<s.matrix.length;j++)
		 {
			 inputArray[j][0]=s.matrix[j][1];
			 inputArray[j][2]=s.matrix[j][2];
			 
		 }
		 for(int j=0;j<s.matrix.length;j++)
		 {
			 inputArray[j][1]=s.matrix[j][0];
			 
		 }
	
		 return inputArray;
 }
 
 /*
  * checks the symmetry of two sparse matrix
  * @param, a SparseMatrix 
  * @return true if symmetrical, false otherwise
  */
  public boolean isSymmetrical(SparseMatrix s)
 {
	 int transpose[][]= helperTranspose(s);
	 boolean flg=true;
	 
	 for(int i=0;i<s.matrix.length;i++)
	 {
		 for(int j=0;j<s.matrix[i].length;j++)
		 {   //checks each element of matrix is equal to its transpose
			 if(transpose[i][j]!=s.matrix[i][j])
			 {
				 flg=false;
				 break;
			 }
		 }
	 }
	
	 
	 return flg;
 }
 
  /*
  * adds two sparse matrix 
  * @param, two sparse matrix as object of  SparseMatrix object
  * @return addition sparse matrix 
  */
  public SparseMatrix addition(SparseMatrix m1, SparseMatrix m2)
 {  
	 try
    {
	  
 
	 int result[][]= new int[m1.row][m1.col];	 
	 if(m1.row!=m2.row || m1.col!= m2.col)
	 {  // if both the matrix are not of same dimensions
		 throw new AssertionError();
	 }
	 
	
	 int a=0,b=0;
	 for(int i=0;i<result.length;i++)
	 {
		 for(int j=0;j<result[i].length;j++)
		 {    // add element of both matrix present at same cell
			 if((m1.matrix[a][0]==i && m1.matrix[a][1]==j) &&  (m2.matrix[b][0]==i && m2.matrix[b][1]==j))
					 
			 {
				 result[i][j]=m1.matrix[a++][2]+m2.matrix[b++][2];
				 
			 }
			 else{  // if first matrix has element at particular  location 
				 if((m1.matrix[a][0]==i && m1.matrix[a][1]==j) )
				 { result[i][j]=m1.matrix[a++][2];
				
				 }
				 
				 else
					// if second matrix has element at particular  location 
					 if(m2.matrix[b][0]==i && m2.matrix[b][1]==j)
					 {
						 result[i][j]=m2.matrix[b++][2];
						 
					 }
					 
			 }
			 }
		 }
	 
	 SparseMatrix answer= new SparseMatrix(result);
	 return answer;
    }
	 catch(Exception exception)
		{
			throw exception;
		}
 } 
 
  /*
  * Multiplies two sparse matrix
  * @param two sparse matrix as object of  SparseMatrix object
  * @return multiplication as sparse matrix or throws error if multiplication is not possible
  */
 public SparseMatrix multiplication(SparseMatrix m1, SparseMatrix m2)
 {   
	 try
	 {
	 int result[][]= new int[m1.row][m2.col];
 
	 if(m1.col!=m2.row)
	 {
		 throw new AssertionError();
	 }
	 int m2Matrix[][] = m2.helperTranspose(m2);

	 ArrayList<Integer>rowlist= new ArrayList<Integer>();
     ArrayList<Integer>collist= new ArrayList<Integer>();
     ArrayList<Integer>valuelist= new ArrayList<Integer>();
	 
	int m1pos, m2pos; 
	 
     // iterate over all elements of first matrix
     for (m1pos = 0; m1pos < m1.matrix.length;) 
     { 
          int r = m1.matrix[m1pos][0]; 

         // iterate over all elements of second matrix
         for (m2pos = 0; m2pos < m2Matrix.length;) { 

             // current column of result matrix 
             // m1 matrix[][0] used as m2Matrix is transposed 
             int c = m2Matrix[m2pos][0]; 
             int tempa = m1pos; 
             int tempb = m2pos; 
             int sum = 0; 

             // iterate over all elements with same row and column value  
            
             while (tempa < m1.matrix.length && m1.matrix[tempa][0] == r 
                    && tempb < m2Matrix.length && m2Matrix[tempb][0] == c) { 

                 if (m1.matrix[tempa][1] < m2Matrix[tempb][1]) 
                     tempa++; 

                 else
                	 if (m1.matrix[tempa][1] > m2Matrix[tempb][1]) 
                          tempb++; 
                     else

                        // same column, so multiply and increment 
                         sum = sum+( m1.matrix[tempa++][2] * m2Matrix[tempb++][2]); 
             } 
             
             // if sum not equal to 0 
             if (sum != 0) 
             {
            	 rowlist.add(r);
            	 collist.add(c);
            	valuelist.add(sum);
             }

             while (m2pos < m2Matrix.length && m2Matrix[m2pos][0] == c) 

                 // jump to next column 
                 m2pos++; 
         } 

         while (m1pos < m1.matrix.length && m1.matrix[m1pos][0] == r) 

             // jump to next row 
             m1pos++; 
     } 
     
    for(int i=0;i<result.length;i++)
     {
    	 for(int j=0;j<result[i].length;j++)
    	 {
    		 for(int k=0;k<rowlist.size();k++)
    		 {
    			 if(rowlist.get(k)==i && collist.get(k)==j)
    			 {
    				 result[i][j]=result[i][j]+valuelist.get(k);
    				 rowlist.remove(k);
    				 collist.remove(k);
    				 valuelist.remove(k);
    				 k=-1;
    			 }
    		 }
    	 }
     }
     
	 
	 SparseMatrix answer= new SparseMatrix(result);
    
     return answer;
	 }
	 catch(Exception exception)
		{
			throw exception;
		}
  }
 
 /*
  * converts any matrix of row column and value form to 2d matrix array
  * @param, matrix , row length, column length
  * @return 2d array as matrix
  */
  private int[][] toMatrix(int [][] m, int r, int c)
 {
	 int [][] result= new int[r][c];
	 int a=0;
	 for(int i=0;i<result.length;i++)
	 {
		 for(int j=0;j<result[i].length;j++)
		 {
			 if(m[a][0]==i && m[a][1]== j)
			 {
				 result[i][j]=m[a++][2];
			 }
		 }
	 }
	 return result;
 }
 
 /*
 * To check equality of two SparseMatrix
 * @param, Two Objects of SparseMartix 
 * @return true if equal, false otherwise 
 */
 public boolean isEqual(SparseMatrix m1, SparseMatrix m2)
 {
	 boolean flg= true;
	 
	 if(m1.matrix.length != m2.matrix.length)
	 {
		 flg= false;
		 return flg;
	 }
	 
	 for(int i=0;i<m1.matrix.length;i++)
	 {
		 for(int j=0;j<m1.matrix[i].length;j++)
		 {
			 if(m1.matrix[i][j]!=m2.matrix[i][j])
				 flg=false;
			 break;
		 }
	 }
	 
	 return flg;
	
 }

 
}
