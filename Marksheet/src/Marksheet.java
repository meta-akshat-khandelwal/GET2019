import java.text.DecimalFormat;
import java.util.*;

public class Marksheet {

	   //to round the values up to 2 decimal places
		DecimalFormat decimalFormat = new DecimalFormat(".##");
		
		//to store the grades given by the user in the list
		ArrayList<Double> marks = new ArrayList<Double>();
		
		/*
		 * returnAverage method is use to compute the average of all grades in the list
		 * @param, it doesn't require any parameter and assumes list is not empty
		 * @return the average of all grades which is a double type value up to 2 decimal places
		 */
		public Double returnAverageOfGrades() throws ArithmeticException
		{
			
			double avgGrades=0.0,sumGrades=0.0;
			int size;
			
			
			
			try
			{
				size=marks.size();
				for(int loop=0 ; loop<size ; loop++)
				{
					sumGrades=sumGrades+marks.get(loop);
				}
				
				avgGrades=sumGrades/size;
			}
			catch(ArithmeticException e)
			{
				throw e;
			}
			
			return Double.parseDouble(decimalFormat.format(avgGrades));
			
		}
		
		/*
		 * returnMaximumOfGrades method is use to find the maximum from all grades in the list
		 * @param, it doesn't require any parameter and assumes list is not empty
		 * @return the maximum from all grades which is a double type value up to 2 decimal places
		 */
		public Double returnMaximumOfGrades() throws ArithmeticException
		{
			
			double max=0.0;
			int size=marks.size();
			
			try
			{
				for(int loop=0 ; loop<size; loop++)
				{
				if(max < marks.get(loop))
					{
						max = marks.get(loop);
					}
				
				}
			}
			catch(ArithmeticException e)
			{
				throw e;
			}
			return Double.parseDouble(decimalFormat.format(max));
		}
		
		/*
		 * returnMinimumOfGrades method is use to find the minimum from all grades in the list
		 * @param, it doesn't require any parameter and assumes list is not empty
		 * @return the minimum from all grades which is a double type value up to 2 decimal places
		 */
		public Double returnMinimumOfGrades() throws ArithmeticException
		{
			
			double min;
			
			min=returnMaximumOfGrades();
			
			try
			{
				int size=marks.size();
				for(int loop=0 ; loop<size; loop++)
				{
					
					if(min > marks.get(loop))
					{
						min = marks.get(loop);
					}
					
				}
			}
			catch(ArithmeticException e)
			{
				throw e;
			}
			
			return Double.parseDouble(decimalFormat.format(min));
		}
		
		/*
		 * returPercentageOfPassed method is use to compute the percentage of students passed among all students
		 * @param, it doesn't require any parameter and assumes list is not empty
		 * @return the percentage of students passed among all in string type which is a double type value up to 2 decimal places 
		 */
		public Double returnPercentageOfPassed() throws ArithmeticException
		{
			
			double percentagePassed ,numberOfStudentsPassed=0.0;
			int size=marks.size();
			
			try
			{
				for(int loop=0 ; loop<size; loop++)
				{
				if(marks.get(loop) >= 40)
					{
						numberOfStudentsPassed++;
					}
					
				}
				percentagePassed = ((double)(numberOfStudentsPassed/size))*100.0;
			}
			catch(ArithmeticException e)
			{
				throw e;
			}
			
			return Double.parseDouble(decimalFormat.format(percentagePassed));
		}
		
		/*
		 * addGrades method is use to add the grades enter by the user in the list
		 * @param, it doesn't require any parameter and assumes list is not empty
		 * @return the boolean if grade is added to list or false it not 
		 */
		public boolean addGrades(double grades)
		{
			if(marks.add(grades))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		
		
	}	
	

