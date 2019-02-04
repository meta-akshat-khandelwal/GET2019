import java.util.Date;
import java.util.List;
/**
 * Performs the following operations
 * 1.Calculate the perimeter
 * 2. Calculate the area
 * 3. Checks for a point is enclosed in shape or not
 * 4. Calculate the distance from origin
 * 5. To get the time of creation of shape
 * @author Akshat Khandelwal
 *
 */

public class Square implements Shapes {

	private static final double noOfSides=4;
	
	private double side;
	private Point origin;
	private Date timeStamp;
	
	public Square(Point origin, List<Integer> parameters)
	{
		side=parameters.get(0);
		timeStamp = new Date();
		this.origin= origin; 
	}
	
	/*
	 * to calculate perimeter 
	 * @param, nothing
	 * @@return perimeter as double value 
	 */
	@Override
	public double getPerimeter()
	{
		return noOfSides*side;
	}
	
	/*
	 * to calculate Area
	 * @param, nothing
	 * @@return Area as double value 
	 */
	@Override
	public double getArea()
	{
		return side*side;
	}
	
	
	/*
	 * to check for a point is enclosed in shape
	 * @param, point to check
	 * @@return true if enclosed, false otherwise 
	 */
	@Override
	public boolean isPointEnclosed(Point point)
	{
		boolean flg= false;
		
		if((origin.getxPoint()<= point.getxPoint() &&
				point.getxPoint()<= side+origin.getxPoint()) &&
				(origin.getyPoint()<= point.getyPoint()  &&
				point.getxPoint()<= side+origin.getxPoint()))
				{
	                 flg=true;		
				}
		
		return flg;
	}
	
	/*
	 * to get the origin 
	 * @param, nothing
	 * @@return point of origin
	 */
	@Override 
	public Point getOrigin()
	{
		return origin;
	}
	
	/*
	 * to get the date and time of creation
	 * @param, nothing
	 * @@return date and time of creation
	 */
	public Date getTimeStamp()
	{
		return timeStamp;
	}
	
	/*
	 * to get the shape
	 * @param, nothing
	 * @@return shape
	 */
	public ShapeType getShape()
	{
		return Shapes.ShapeType.Square;
	}
	
	
	/*
	 * to calculate distance from origin
	 * @param, nothing
	 * @@return distance from origin 
	 */
	public double calculateDistanceFromOrigin()
	{
		double x1= 0;
		double y1= 0;
		double x2= origin.getxPoint();
		double y2= origin.getyPoint();
		
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
}
