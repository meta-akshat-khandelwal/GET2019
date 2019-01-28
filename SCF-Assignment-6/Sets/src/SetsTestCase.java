import static org.junit.Assert.*;

import org.junit.Test;
public class SetsTestCase {


	//test case for  isMember method
	
	// positive test case
	@Test
	public void test_isMember_with_Integer_should_return_true()
	{
		int num[] = new int[]{1,2,3,4,5};
		int value=2;
		InSet s= new InSet(num);
		assertEquals(true, s.isMember(value));
	}
	
	//negative test case
	@Test
	public void test_isMember_with_Integer_should_return_false()
	{
		int num[] = new int[]{1,2,3,4,5};
		int value=10;
		InSet s= new InSet(num);
		assertEquals(false, s.isMember(value));
	}
	
	//test case for  isSubSet method
	
	// positive test case
	@Test
	public void test_isSubSet_with_Set_should_return_true()
	{
		int num[] = new int[]{1,2,3,4,5};
		int value[]=new int[]{1,2,3};
		InSet s= new InSet(num);
		InSet s1= new InSet(value);
		assertEquals(true, s.isSubSet(s1));
	}
	
	//negative test case
	@Test
	public void test_isSubSet_with_Set_should_return_false()
	{
		int num[] = new int[]{1,2,3,4,5};
		int value[]=new int[]{10,20,30};
		InSet s= new InSet(num);
		InSet s1= new InSet(value);
		assertEquals(false, s.isSubSet(s1));
	}
	
	// test case of union method 
	
	
	
	// positive test case
	@Test
	public void test_getComplement_with_Set_should_return_complement()
	{
		int value[] = new int[]{1,2,3,4,5};
		int expected[]=new int[]{0,6,7,8,9};
		InSet s= new InSet(expected);
		InSet s1= new InSet(value);
		InSet inset=s1.getComplement();
		assertEquals(true,s.equals(inset) );
	}
	
	//negative test case
	@Test
	public void test_getComplement_with_Set_should_not_return_correct_complement()
	{
		int value[] = new int[]{1,2,3,4,5};
		int expected[]=new int[]{6,7,8,9,10};
		InSet s= new InSet(expected);
		InSet s1= new InSet(value);
		InSet inset=s1.getComplement();
		assertEquals(false,s.equals(inset) );
	}
	
	// test case of union method 
	
	
	// positive test case
	@Test
	public void test_Union_with_Set_should_return_Union()
	{
		int value1[]={1,2,3,4,5};
		int value2[]={3,4,5,6,7};
		int expected[]={1,2,3,4,5,6,7};
		InSet s1= new InSet(value1);
		InSet s2= new InSet(value2);
		InSet expect= new InSet(expected);
		InSet result= s1.union(s1, s2);
		assertEquals(true,result.equals(expect) );
		
		
	}
	
	//negative test case
	@Test
	public void test_Union_with_Set_should_not_return_Union()
	{
		int value1[]={1,2,3,4,5};
		int value2[]={3,4,5,6,7};
		int expected[]={1,2,3,4,5};
		InSet s1= new InSet(value1);
		InSet s2= new InSet(value2);
		InSet expect= new InSet(expected);
		InSet result= s1.union(s1, s2);
		assertEquals(false,result.equals(expect));
		
	}
	
	// test case of size method
	
	
	// positive test case
	@Test
	public void test_size_with_set_should_return_Size()
	{
		int value1[]={1,2,3,4,5};
		InSet s1= new InSet(value1);
		assertEquals(5,s1.size());
	}
	
	
	//negative test case
	@Test
	public void test_size_with_set_should_not_return_Correct_Size()
	{
		int value1[]={1,2,3,4,5};
		InSet s1= new InSet(value1);
		assertNotEquals(8,s1.size());
	}
}
