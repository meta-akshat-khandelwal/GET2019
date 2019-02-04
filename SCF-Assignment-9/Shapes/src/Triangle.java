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

public class Triangle implements Shapes {
	
	double base;
	double height;
	Point origin;
	private Date timeStamp;
	double hypotenuse;
	
	public Triangle(Point origin, List<Integer> parameters)
	{
		base=parameters.get(0);
		height=parameters.get(1);
		timeStamp = new Date();
		this.origin= origin; 
		hypotenuse= Math.sqrt((base*base)+(height*height));
	}
	
	/*
	 * to calculate Area
	 * @param, nothing
	 * @@return Area as double value 
	 */
	@Override
	public double getArea()
	{
		return 0.5*base*height;
	}
	
	/*
	 * to calculate perimeter 
	 * @param, nothing
	 * @@return perimeter as double value 
	 */
	@Override
	public double getPerimeter()
	{
		return base+height+hypotenuse;
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
	 * Calculate area of triangle inside a triangle
	 * @param, x and y coordinates of all three vertex of triangle
	 * @return area of Sub triangle
	 */
	public double calculateSubArea(double x1, double y1, double x2, double y2,double x3, double y3)
	{
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ 
                x3*(y1-y2))/2.0); 
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
		Point p2=new Point(origin.getxPoint()+base,origin.getyPoint());
		Point p3= new Point(origin.getxPoint(),origin.getyPoint()+height);
		Point p1= origin;
		
		double x1=p1.getxPoint();
		double x2=p2.getxPoint();
		double x3=p3.getxPoint();
		double y1=p1.getyPoint();
		double y2=p2.getyPoint();
		double y3=p3.getyPoint();
		
		double subArea1=calculateSubArea(point.getxPoint(), point.getyPoint(), x2, y2, x3, y3); 
		double subArea2 = calculateSubArea(x1, y1, point.getxPoint(), point.getyPoint(), x3, y3); 
	    double subArea3 = calculateSubArea(x1, y1, x2, y2,point.getxPoint(), point.getyPoint()); 
		
		
		if(getArea()== subArea1+subArea2+subArea3)
		{
			flg= true;
		}
		
		return flg;
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
		return Shapes.ShapeType.Triangle;
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
