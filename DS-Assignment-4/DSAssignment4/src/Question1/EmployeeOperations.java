package Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EmployeeOperations {

	//to store the data of employees 
		HashMap<Integer, Employee> allEmployee = new HashMap<Integer, Employee>();
		
		
		/**
		 * to add the data into the map
		 * @param employee
		 * @return true of employee is added into the map
		 * @throws Exception if employee with the same id already exist into the map
		 */
		public boolean addEmployee(Employee employee) throws Exception
		{
			if(allEmployee.containsKey(employee.getEmpid()))
				throw new Exception("Employee Already Exists");
			
			allEmployee.put(employee.getEmpid(), employee);
			return true;	
		}
		
		//sort the list of employees into the natural order
		public List<Employee> sortEmployeesByID()
		{
			List<Employee> employees = getListOfEmployee();
			Collections.sort(employees);
			return employees;
		}
		
		//returns the list of employees 
		public  List<Employee> getListOfEmployee()
		{
			List<Employee> employees = new ArrayList<Employee>(allEmployee.values());
			return employees;
		}
		
}
