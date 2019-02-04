import java.util.Comparator;
import java.util.Date;
/*
 * Sorts the list by comparing following
 * 1. Area
 * 2. Perimeter
 * 3.timeStamp
 * 4. origin distance
 */
public class Sort {


	// sorts the list with comparing the area of the two shapes
	public static Comparator<Shapes> areaComparator = new Comparator<Shapes>() { 
		//anonymous class

		@Override
		public int compare(Shapes shape1, Shapes shape2) {
			double area1 = shape1.getArea();
			double area2 = shape2.getArea();
			
			if(area1 > area2)
				return 1;
			else if(area1 < area2)
				return -1;
			else
				return 0;
		}
		
	};
	
	
	//sorts the list with comparing the perimeter of the two shapes
	public static Comparator<Shapes> perimeterComparator = new Comparator<Shapes>() {
		//anonymous class
		
		@Override
		public int compare(Shapes shape1, Shapes shape2) {
			double peri1 = shape1.getPerimeter();
			double peri2 = shape2.getPerimeter();
			
			if(peri1 > peri2)
				return 1;
			else if(peri1 < peri2)
				return -1;
			else
				return 0;
		}
		
	};
	
	//sorts the list with comparing the timestamp of the shapes
	public static Comparator<Shapes> timestampComparator = new Comparator<Shapes>() {
		//anonymous class
		
		@Override
		public int compare(Shapes shape1, Shapes shape2) {
			Date time1 = shape1.getTimeStamp();
			Date time2 = shape2.getTimeStamp();
			
			if(time1.after(time2))
				return -1;
			else if(time1.before(time2))
				return 1;
			else
				return 0;
				
		}
		
	};
	
	//sorts the list with comparing the distance between the two origin of screen and shape
	public static Comparator<Shapes> originDistanceComparator = new Comparator<Shapes>() {
		//anonymous class
		
		@Override
		public int compare(Shapes shape1, Shapes shape2) {
			double distance1 = shape1.calculateDistanceFromOrigin();
			double distance2 = shape2.calculateDistanceFromOrigin();
			
			if(distance1 > distance2)
				return 1;
			else if(distance1 < distance2)
				return -1;
			else
				return 0;
				
		}
		
	};
}
