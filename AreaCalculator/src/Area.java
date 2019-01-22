import java.util.*;



/*
 * this class calculates the area 
 */
public class Area {
	
	

	Scanner sc= new Scanner(System.in);
	/*
	 * calculateTriangleArea method to calculate the area of the triangle
	 * @param baseOfTriangle which hold the length of base of triangle and assuming base>0
	 * @param heightofTriangle which holds the height of the triangle and assuming height>0
	 * @return the area of the triangle as a double value 
	 */
	
	public double calculateTriangleArea(double baseOfTriangle,double heightofTriangle) throws ArithmeticException
	{
		
		double result=0.0;
		
		
		try
		{
			result= 0.5*(baseOfTriangle*heightofTriangle);                  // area= 0.5*base*height
			
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return result ;
	}
	
	/*
	 * calculateSquareArea method to calculate the area of the square
	 * @param sideOfSquare which hold the length of square and assuming length>0
	 * @return the area of the square as a double value 
	 */
	public double calculateSquareArea(double sideOfSquare) throws ArithmeticException
	{
		double result=0.0;
		
		try
		{
			result= sideOfSquare*sideOfSquare;                        // area= side*side
			
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return result;
	}
	/*
	 * calculateRectangleArea method to calculate the area of the rectangle
	 * @param lengthOfRectangle which hold the length or height of rectangle and assuming length>0
	 * @param breadthOfRectangle which holds the breadth of the rectangle and  assuming breadth>0
	 * @return the area of the rectangle as a double value
	 */
	
	public double calculateRectangleArea(double lengthOfRectangle,double breadthOfRectangle) throws ArithmeticException
	{
		double result=0.0;
		
		
		try
		{
			result= lengthOfRectangle*breadthOfRectangle;                     // area=length*breadth
			
		}
		catch(ArithmeticException e)
		{
			throw e;
		}
		
		return result;
	}
	
	/*
	 * calculateCircleArea method to calculate the area of the circle
	 * @param radiusOfCircle which hold the radius of circle and  assuming radius>0
	 * @return the area of the circle as a double value 
	 */
	
	public double calculateCircleArea(double radiusOfCircle)throws ArithmeticException
	{
		double result=0.0;
		
		

		try
		{
			result= (2*3.14)*radiusOfCircle;                      // area=2*3.14*radius
			
		}
		catch(ArithmeticException e)
		{
			throw e;
		}
		
		return result;
	}
}
