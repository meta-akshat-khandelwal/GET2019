package Question1;



import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	static EmployeeOperations employeeOperations= new EmployeeOperations();
	
	//sorts the list of employees according to their name
		public static List<Employee> sortEmployeesByName()
		{
			List<Employee> employees = employeeOperations.getListOfEmployee();
			Collections.sort(employees, nameSorting);
			return employees;
		}
		public static Comparator<Employee> nameSorting = new Comparator<Employee>() { 
			//anonymous class

			@Override
			public int compare(Employee employee1, Employee employee2) {
				String empName1 = employee1.getName().toUpperCase();
				String empName2 = employee2.getName().toUpperCase();
				return empName1.compareTo(empName2);

			}	
		}; 
		
		
}
