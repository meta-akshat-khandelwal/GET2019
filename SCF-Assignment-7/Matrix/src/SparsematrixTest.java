import static org.junit.Assert.*;

import org.junit.Test;

public class SparsematrixTest {
	
	//  Test Case of transpose method
	@Test
	public void test_transpose_with_SparseMatrix_should_return_transpose()
	{
		int[][] input = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 1 , 1},
		};
		int[][] expected = {
				{1 , 0 , 0},
				{0 , 1 , 1},
				{0 , 0 , 1},
		};
		SparseMatrix m1= new SparseMatrix(input);
		SparseMatrix m2= new SparseMatrix(expected);
		assertEquals(true,m2.isEqual(m1.getTranspose(m1),m2));
		
	}
	
	
	
	@Test
	public void test_transpose_with_SparseMatrix_should_not_return_transpose()
	{
		int[][] input = {
				{1 , 0 },
				{0 , 1 },
				{0 , 1 },
		};
		int[][] expected = {
				{1 , 0 , 1},
				{0 , 1 , 1},
		};
		SparseMatrix m1= new SparseMatrix(input);
		SparseMatrix m2= new SparseMatrix(expected);
		assertEquals(false, m2.isEqual(m1.getTranspose(m1),m2));
		
	}
	
	//Test Case of isSymmetrical method
	
	@Test
	public void test_isSymmetrical_with_SparseMatrix_should_return_true()
	{
		int[][] input = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		SparseMatrix m1= new SparseMatrix(input);
		assertEquals(true, m1.isSymmetrical(m1));
		
	}
	
	@Test
	public void test_isSymmetrical_with_SparseMatrix_should_return_false()
	{
		int[][] input = {
				{1 , 0 , 0 , 0},
				{0 , 1 , 0 , 0},
				{0 , 0 , 1 , 0},
				{0 , 1 , 0 , 1},
		};
		SparseMatrix m1= new SparseMatrix(input);
		assertEquals(false, m1.isSymmetrical(m1));
		
	}
	
	// Test Case of addition method
	@Test
	public void test_addition_with_two_SparseMatrix_should_return_addition()
	{
		int[][] input1 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] input2 = {
				{1 , 1 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] expected = {
				{2 , 1 , 0},
				{0 , 2 , 0},
				{0 , 0 , 2},
		};
		SparseMatrix m1 = new SparseMatrix(input1);
		SparseMatrix m2 = new SparseMatrix(input2);
		SparseMatrix result = new SparseMatrix(expected);
		assertEquals(true, result.isEqual(m1.addition(m1,m2),result));
		
	}
	
	@Test(expected = AssertionError.class)
	public void test_addition_with_two_SparseMatrix_should_return_error()
	{
		int[][] input1 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] input2 = {
				{1 , 1 , 0},
				{0 , 1 , 0},
		};
		int[][] expected = {
				{2 , 1 , 0},
				{0 , 2 , 0},
				{0 , 0 , 1},
		};
		SparseMatrix m1 = new SparseMatrix(input1);
		SparseMatrix m2 = new SparseMatrix(input2);
		SparseMatrix result = new SparseMatrix(expected);
		assertEquals(true, result.isEqual(m1.addition(m1,m2),result));
		
	}
	
	// Test Case of multiplication method
	
	@Test
	public void test_multiplication_with_two_SparseMatrix_should_return_multiplication()
	{
		int[][] input1 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] input2 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] expected = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		SparseMatrix m1 = new SparseMatrix(input1);
		SparseMatrix m2 = new SparseMatrix(input2);
		SparseMatrix result = new SparseMatrix(expected);
		assertEquals(true, result.isEqual(m1.multiplication(m1,m2),result));
		
	}
	
	@Test(expected = AssertionError.class)
	public void test_multiplication_with_two_SparseMatrix_should_return_error()
	{
		int[][] input1 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] input2 = {
				{1 , 1 , 0},
				{0 , 1 , 0},
		};
		int[][] expected = {
				{2 , 1 , 0},
				{0 , 2 , 0},
				{0 , 0 , 2},
		};
		
		//matrix can't be multiplied as no. of column if first is not equal to no. of row in second
		
		SparseMatrix m1 = new SparseMatrix(input1);
		SparseMatrix m2 = new SparseMatrix(input2);
		SparseMatrix result = new SparseMatrix(expected);
		assertEquals(true, result.isEqual(m1.multiplication(m1,m2),result));
		
		
	}
	
	
	
	@Test
	public void test_multiplication_with_two_SparseMatrix_should_return_multiplication_1()
	{
		int[][] input1 = {
				{1 , 0 , 1},
				{0 , 1 , 0},
				{0 , 0 , 1},
		};
		int[][] input2 = {
				{1 , 0 , 0},
				{0 , 1 , 0},
				{1 , 0 , 1},
		};
		int[][] expected = {
				{2 , 0 , 1},
				{0 , 1 , 0},
				{1 , 0 , 1},
		};
		SparseMatrix m1 = new SparseMatrix(input1);
		SparseMatrix m2 = new SparseMatrix(input2);
		SparseMatrix result = new SparseMatrix(expected);
		assertEquals(true, result.isEqual(m1.multiplication(m1,m2),result));
		
	}
	
	
}
