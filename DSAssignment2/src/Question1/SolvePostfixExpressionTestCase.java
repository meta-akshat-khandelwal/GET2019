package Question1;
/**
 * @author Akshat
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolvePostfixExpressionTestCase {

	
	// test case for evaluate method
	@Test
	public void test_evaluateWith_validExpression_shouldReturnValue()
	{
		SolvePostfixExpression solvePostfixExpression= new SolvePostfixExpression();
		try{
			assertEquals(757,solvePostfixExpression.evaluate("100 200 + 2 / 5 * 7 +"));
	        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
    }
	
	
	// test case for evaluate method
	@Test
	public void test_evaluateWithNull_shouldReturnZero()
	{
		SolvePostfixExpression solvePostfixExpression= new SolvePostfixExpression();
		try{
			assertEquals(0,solvePostfixExpression.evaluate(null));
	        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
    }
	
	// test case for evaluate method
	
	@Test(expected= Exception.class)
	public void test_evaluateWith_InvalidExpression_shouldthrowError() throws Exception
	{
		SolvePostfixExpression solvePostfixExpression= new SolvePostfixExpression();

		assertEquals(0,solvePostfixExpression.evaluate("100 200 + 2 Z 5 * 7 +"));
    }
}
