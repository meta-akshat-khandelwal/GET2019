import static  org.junit.Assert.*;    
import org.junit.Test;
/*
 * Test case Class of Search Class
 */
public class SearchTest {
	
    Search search= new Search();
	
	//test case of null array in binary search
		@Test(expected = AssertionError.class)
		public void testcaseBinarySearchNullArrayNegativeTest()
		{
			double input[]=new double[]{};
			double find =4;
			search.binarySearch(input, 0, input.length-1, find);
		}
		
		//test case of input in binary search
		@Test
		public void testcaseBinarySearchInput()
		{
			double input[]=new double[]{1,2,3,4,5,6};
			double find=4;
			int expected =4;
			assertEquals(expected, search.binarySearch(input, 0, input.length-1, find));
		}
		
		//test case of input with no element present in binary search
		@Test
		public void testcaseBinarySearchNegativeTest()
		{
			double input[]=new double[]{1,2,3,4,5,6};
			double find=4;
			int expected =-1;
			assertNotEquals(expected, search.binarySearch(input, 0, input.length-1, find));
		}
		
		//test case of null array in linear search
		@Test(expected = AssertionError.class)
		public void testcaseLinearSearchNullArrayNegativeTest()
		{
			double input[]=new double[]{};
			double find =4;
			search.linearSearch(input, 0, find);
		}
		
		//test case of input in linear search
		@Test
		public void testcaseLinearSearchInput()
		{
			double input[]=new double[]{1,3,2,5,4,6};
			double find=4;
			int expected =5;
			assertEquals(expected, search.linearSearch(input, 0, find));
		}
		
		//test case of input with no element present in linear search
		@Test
		public void testcaseLinearSearchNegativeTest()
		{
			double input[]=new double[]{1,3,2,5,4,6};
			double find=4;
			int expected =-1;
			assertNotEquals(expected, search.linearSearch(input, 0, find));
		}

	
}
