import java.util.List;;
/**
 * Factory Class for various shapes
 * @author Akshat Khandelwal
 *
 */
public class ShapeFactory {
/*
 * Shape object for corresponding shape
 * @param, Shape on screen
 * @param, Origin points of shape
 * @param, various specification of shape
 * @return shape
 */
	public static Shapes getShape(String  shape, Point origin, List<Integer> parameters) throws Exception
	{
		
		// if parameters are 0, throws exception
		if(parameters.size()<1)
			throw new Exception("Please provide valid paramters");
		
	
		Shapes.ShapeType shapes= Shapes.ShapeType.valueOf(shape);
		
		switch(shapes)
		{
		case Rectangle: if(parameters.size()!=2)
			            throw new Exception("Please provide valid paramters");
			            
		                else
		                return new Rectangle(origin, parameters);
			                             
		case Circle:    if(parameters.size()!=1)
                        throw new Exception("Please provide valid paramters");
        
                        else
                        return new Circle(origin, parameters);
                                         
		case Square:    if(parameters.size()!=1)
                        throw new Exception("Please provide valid paramters");
        
                        else
                        return new Square(origin, parameters);
                                         
		case Triangle:  if(parameters.size()!=2)
                         throw new Exception("Please provide valid paramters");
        
                        else
                        return new Triangle(origin, parameters);
                                      
        default:        return null;                                 
		}
	}
}
