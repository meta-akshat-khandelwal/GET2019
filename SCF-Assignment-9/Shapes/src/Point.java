/**
 * To store the coordinates
 * Performs following task
 * 1. Get the X Coordinates 
 * 2. Get the Y Coordinates 
 * @author Akshat Khandelwal
 *
 */
public class Point {

	private double xPoint;
	private double yPoint;
	
	public Point(double x, double y)
	{
		xPoint=x;
		yPoint=y;
	}
	/*
	 * get x coordinates
	 * @param, nothing
	 * @return x coordinates
	 */
	public double  getxPoint()
	{
		return xPoint;
	}
	
	
	/*
	 * get y coordinates
	 * @param, nothing
	 * @return y coordinates
	 */
	public double getyPoint()
	{
		return yPoint;
	}
}
