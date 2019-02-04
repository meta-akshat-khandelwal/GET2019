import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestScreen {

	//  fix the dimension of screen
	Screen screen = new Screen(500,500);
	List<Integer> parameter = new ArrayList<Integer>();
	Point p;
	
   @Before
   public void init() throws Exception
   {    
	    p= new Point(10,10);
		parameter.add(5);
		screen.addShapeToScreen("Circle", p, parameter);
		parameter.clear();
		
	    p= new Point(15,15);
		parameter.add(7);
		screen.addShapeToScreen("Circle", p, parameter);
		parameter.clear();
		
		
		p= new Point(10,15);
		parameter.add(8);
		screen.addShapeToScreen("Square", p, parameter);
		parameter.clear();
		
		p= new Point(15,10);
		parameter.add(7);
		parameter.add(5);
		screen.addShapeToScreen("Rectangle", p, parameter);
		parameter.clear();
   }
   
   // test case to add shape 
   @Test
   public void testAddShapeToScreen_withValidShape_shouldReturn_true() throws Exception
   {
        p=new Point(15, 15);
        parameter.add(7);
		parameter.add(5);
		assertTrue(screen.addShapeToScreen("Rectangle", p, parameter));
		parameter.clear();
   }
   
   // test case to delete shape at particular point
   @Test
   public void testdeleteShape_withValidShape_shouldReturn_true() throws Exception
   {
        p=new Point(10, 15);
        parameter.add(7);
		parameter.add(5);
		assertTrue(screen.deleteShape("Square", p));
		parameter.clear();
   }
   
   // test case to add shape to screen with null as parameter
   @Test
   public void testAddShapeToScreen_withValidShape_shouldthrow_error() 
   {
	   
		p = new Point(-15,-20);
		try {
			screen.addShapeToScreen("Rectangle", p, parameter);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		parameter.clear();
   }
   
   // sort list of shapes on perimeter basis
   @Test
   public void testsortList_withValidShape_shouldReturn_listOfShapes() throws Exception
   {
       
        List<Shapes> result = screen.sortList("perimeter");
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i).getShape()+"  "+result.get(i).getPerimeter());
   }
   
   // test case to list of shapes enclosed in particular point
   @Test
   public void testisShapeEnclosingPoint_withValidShape_shouldReturn_listOfShapes() throws Exception
   {
       p= new Point(15,15);
        List<Shapes> result = screen.isShapeEnclosingPoint(p);
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i).getShape()+"  "+result.get(i).getPerimeter());
   }
   
   
   //test case to delete type of shapes 
   @Test
   public void testdeleteShapesOfSpecificType_withValidShape_shouldReturn_true() throws Exception
   {
	   assertTrue(screen.deleteShapesOfSpecificType("Circle"));
   }
   
   
   
}
