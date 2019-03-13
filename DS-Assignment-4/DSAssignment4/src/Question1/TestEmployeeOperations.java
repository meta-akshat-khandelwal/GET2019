package Question1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestEmployeeOperations
{
	
	// test case to adds employees 
	@Test
	public void test_addEmployee_withValidEmployeeObjects_shouldReturn_true()
	{
		EmployeeOperations employeeMain = new EmployeeOperations();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(4,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Anurag", "Allahbaad")));
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	//  test case to sort employees by their id 
	@Test
	public void testSortByID_withValidEmployeeObjects_shouldReturn_true()
	{
		EmployeeOperations employeeMain = new EmployeeOperations();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(9,"Anurag", "Allahbaad")));
			List<Employee> sortEmployees = employeeMain.sortEmployeesByID();
			for(Employee e: sortEmployees)
			{
				System.out.println(e.getEmpid()+" "+e.getName()+" "+e.getAddress());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
//  test case to sort employees by their name 
	@Test
	public void testSortByName_withValidEmployeeObjects_shouldReturn_true()
	{
		EmployeeOperations employeeMain = new EmployeeOperations();
		try 
		{
			assertTrue(employeeMain.addEmployee(new Employee(1,"Amit", "Surat")));
			assertTrue(employeeMain.addEmployee(new Employee(5,"Akshat", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(2,"Chintu", "Bhiwadi")));
			assertTrue(employeeMain.addEmployee(new Employee(3,"Vijay", "Jaipur")));
			assertTrue(employeeMain.addEmployee(new Employee(9,"Anurag", "Allahbaad")));
			List<Employee> sortEmployees = Sort.sortEmployeesByName();
			for(Employee e: sortEmployees)
			{
				System.out.println(e.getEmpid()+" "+e.getName()+" "+e.getAddress());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	
}
