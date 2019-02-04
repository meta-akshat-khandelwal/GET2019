import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Creates virtual screen on which various shapes can be drawn
 * performs following operations
 * 1. Validity of coordinates
 * 2. Validity of parameters
 * 3. add shape to screen
 * 4. checks for availability of shape in screen
 * 5. deletes particular shape
 * 6. checks  for shapes enclosed by particular point
 * 7. sorts the list of shapes in screen  
 *@author Akshat Khandelwal 
 **/
public class Screen {

	double xMax;
	double yMax;
	ArrayList<Shapes> listOfShapes;
	

	public Screen(double xmax, double ymax)
	{
		xMax=xmax;
		yMax=ymax;
		listOfShapes= new ArrayList<Shapes>();
	}
	
	/*
	 * checks for validity of coordinates of point
	 * @param Coordinates
	 * @return true if valid, false otherwise
	 */
	public boolean isValidCoodinates(Point point)
	{
		if(xMax< point.getxPoint() || yMax<point.getyPoint() )
			return false;
		
		return true;
	}
	
	
	/*
	 * checks for validity of parameters
	 * @param list of parameters
	 * @return true if valid, false otherwise
	 */
	public boolean isValidParamters(List<Integer> paramters)
	{
		boolean flg=true;
		 for(int i=0;i<paramters.size();i++)
		 {
			 if(paramters.get(i)<0)
				 return false;
		 }
		
		return flg;
	}
	
	
	/*
	 * add shape to screen
	 * @param type of shape
	 * @param, Points of origin 
	 * @param, list of parameters
	 * @return, true if shape is add to screen, false otherwise
	 */
	
	public boolean addShapeToScreen(String shape, Point originpoint, List<Integer> parameters) throws Exception
	{
		boolean flg=false;
		
		// checks shape is null or not
		if(shape==null)
			throw new Exception("Shape cannot be null");
		
		// checks for coordinates
		if(!isValidCoodinates(originpoint))
			throw new Exception("Please provide valid coordinates");
		
		// checks for validity of parameters
		if(!isValidParamters(parameters))
		{
			throw new Exception("Please provide valid paramters ");
		}
		
		Shapes shapeType = ShapeFactory.getShape(shape,originpoint,parameters);
		if(listOfShapes.add(shapeType))
		{
			System.out.println("Added");
		   flg=true;
		}
		return flg;
	}
	
	/*
	 * check available of shape
	 * @param, shape
	 * @param, point of origin
	 * @return shape if available, null otherwise
	 */
	public Shapes checkAvailableShape(Shapes.ShapeType shape , Point originPoint)
	{
		
		for(int i=0; i<listOfShapes.size(); i++)
		{
			Shapes existingShape = listOfShapes.get(i);
			Point origin = existingShape.getOrigin();
			
			//checking the shape at given origin point is available or not 
			if(shape == existingShape.getShape() && 
					origin.getxPoint() == originPoint.getxPoint()
					&& origin.getyPoint() == originPoint.getyPoint())
			{
				return existingShape;
			}
			
		}
		return null;
	}
	
	/*
	 * delete any particular shape
	 * @param, shape
	 * @param,origin points
	 * @return true if successfully delete, throws error if shape not found
	 */
 	public boolean deleteShape(String shape , Point originPoint) throws Exception 
	{
		if(shape == null)
			throw new Exception("Shape cannot be null");
		
		//converting the string value to the enum value
		Shapes.ShapeType shapeEnum = Shapes.ShapeType.valueOf(shape);
		
		//checking the shape is available or not
		Shapes foundShape = checkAvailableShape(shapeEnum , originPoint);
		
		if(foundShape == null)
			throw new Exception("Shape Not found");
		
		listOfShapes.remove(foundShape);
		System.out.println("Deleted");
		return true;
		
	}
	
 	/*
 	 * delete shape of specific type
 	 * @param shape
 	 * @return true if successful, throws error if shape is null
 	 */
 	public boolean deleteShapesOfSpecificType(String shape) throws Exception
 	{
 		if(shape==null)
			throw new Exception("Shape cannot be null");
 		
 		boolean flg=true;
 		ArrayList<Shapes> deletedShapes= new ArrayList<Shapes>();
 		Shapes.ShapeType shapeType = Shapes.ShapeType.valueOf(shape);	
 		for(int i=0;i<listOfShapes.size();i++)
 		{
 			Shapes s= listOfShapes.get(i);
 			if(shapeType==s.getShape())
 			{
 				deletedShapes.add(listOfShapes.get(i));
 				
 			}
 		}
 		//remove the shape from list
 		for(Shapes s : deletedShapes)
		{
 			listOfShapes.remove(s);
			System.out.println("Deleted");
		}

 		return flg;
 	}
 	
 	
 	/*
 	 * list of shapes enclosing particular point on screen
 	 * @param, coordinates of point
 	 * @return list of enclosed shapes
 	 */
 	public List<Shapes> isShapeEnclosingPoint(Point point) throws Exception
	{
 		if(point.getxPoint()<0 || point.getyPoint()<0)
 			throw new Exception("Coordinates cannot be negative");
 		
		List<Shapes> enclosedShape = new ArrayList<Shapes>();
		for(int i=0;i<listOfShapes.size();i++)
		{
			Shapes shape = listOfShapes.get(i);
			if(shape.isPointEnclosed(point))
			{
				enclosedShape.add(shape);
			}
		}
		return enclosedShape;
	}
 	
 	/*.
 	 * list of shapes sorted in various order
 	 * @param,choice for which list to be sorted
 	 * @return list in sorted form
 	 */
 	public List<Shapes> sortList(String choice) throws Exception
	{
		switch(choice)
		{
		case "area":
			                  Collections.sort(listOfShapes, Sort.areaComparator);
			                  return listOfShapes;
		case "perimeter":
			                   Collections.sort(listOfShapes, Sort.perimeterComparator);
			                   return listOfShapes;
		case "origin":
			                    Collections.sort(listOfShapes, Sort.originDistanceComparator);
			                    return listOfShapes;
		case "timestamp":
			                    Collections.sort(listOfShapes, Sort.timestampComparator);
			                    return listOfShapes;
		default:
			throw new Exception("Invalid choice");
		}
		
	}
 	
 	
	public static void main(String args[]) throws Exception
	{
		Screen screen= new Screen(500,500);
		List<Integer> parameters;
		Point p;
		
		p= new Point(10,10);
		parameters= new ArrayList<Integer>();
		parameters.add(5);
		screen.addShapeToScreen("Circle", p, parameters);
		
	    p= new Point(15,15);
		parameters= new ArrayList<Integer>();
		parameters.add(7);
		screen.addShapeToScreen("Circle", p, parameters);
		
		
		p= new Point(10,15);
		parameters= new ArrayList<Integer>();
		parameters.add(8);
		screen.addShapeToScreen("Square", p, parameters);
		
		p= new Point(15,10);
		parameters= new ArrayList<Integer>();
		parameters.add(7);
		parameters.add(5);
		screen.addShapeToScreen("Rectangle", p, parameters);
		
		screen.deleteShapesOfSpecificType("Circle");
		
		Collections.sort(screen.listOfShapes , Sort.perimeterComparator);
		
		for(int i=0;i<screen.listOfShapes.size() ; i++)
			System.out.println(screen.listOfShapes.get(i).getPerimeter());
	
		p= new Point(10,15);
		parameters= new ArrayList<Integer>();
		try{
		screen.addShapeToScreen("Square", p, parameters);
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}	
}
