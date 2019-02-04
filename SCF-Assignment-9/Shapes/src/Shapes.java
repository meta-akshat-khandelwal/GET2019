import java.util.Date;

/**
 * Interface 
 * @author Akshat Khandelwal
 */


public interface Shapes {

	public Point getOrigin();
	
	public double getPerimeter();
	
	public double getArea();
	
	public boolean isPointEnclosed( Point p);
	
	public ShapeType getShape();
	
	public Date getTimeStamp();
	
	public double calculateDistanceFromOrigin();
	
	 enum ShapeType{
		Square, Rectangle, Circle, Triangle;
	}

	
	
}
