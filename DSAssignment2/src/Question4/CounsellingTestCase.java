package Question4;

import org.junit.Test;

public class CounsellingTestCase {
	@Test
	public void test() throws Exception
	{
		
		Counselling counselling = new Counselling();
		String path = "C:/Users/AMIT-PC/Desktop/";
		String studentPrefernce = "C:/Users/admin/Desktop/student.xls";
		String programCapacity = "C:/Users/admin/Desktop/program.xls";
		counselling.studentCouncil(path, studentPrefernce, programCapacity);
	}	
}
