import static org.junit.Assert.*;
import org.junit.Test;


public class PolynomialTest {

	//test case of degree method
	
	@Test
	public void test_degree_with_polynomialShould_return_degree()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		int expected =2;
		assertEquals(expected, p1.degree());
	}
	
	// test case of evaluate method
	
	@Test
	public void test_evaluate_with_polynomialShould_return_value()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		float value=1;
		float expected =16.0f;
		assertEquals(expected, p1.evaluate(value),0);
	}
	
	
    //test case of add poly method
	
	@Test
	public void test_addPoly_with_polynomialShould_return_addition_1()
	{
		try{
			
		
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,0,3,6});
		int result[] = new int[]{6,8,6,6};
		assertArrayEquals(result, p1.addPoly(p1, p2));
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	
	@Test
	public void test_addPoly_with_polynomialShould_return_additio_2()
	{
		try{
			
		
		Polynomial p1=new Polynomial(new int[]{5,0,0});
		Polynomial p2 = new Polynomial(new int[]{1,2,3,4,5,6});
		int result[] = new int[]{6,2,3,4,5,6};
		assertArrayEquals(result, p1.addPoly(p1, p2));
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	// test case of multiply poly
	@Test
	public void test_multiplyPoly_with_polynomial_should_return_multiplication_1()
	{
		try
		{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,2,3,6});
		int result[] = {5,18,34,60,57,18};
		assertArrayEquals(result, p1.multiplyPoly(p1, p2));
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test
	public void test_multiplyPoly_with_polynomial_should_return_multiplication_2()
	{
		try{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,0,3,6});
		int result[] = {5,8,18,54,57,18};
		assertArrayEquals(result, p1.multiplyPoly(p1, p2));
		}
		catch(Exception e)
		{
			
		}
	}
}
