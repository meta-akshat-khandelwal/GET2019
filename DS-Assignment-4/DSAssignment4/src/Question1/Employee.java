package Question1;

public class Employee implements Comparable<Employee> {

	private int empid;
	private String name;
	private String address;
	
	
	
	public Employee(int empid, String name, String address) {
		super();
		this.empid = empid;
		this.name = name;
		this.address = address;
	}
	public int getEmpid() {
		return empid;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public int compareTo(Employee employee) {
		int id1 = this.getEmpid();
		int id2 = employee.getEmpid();
		
		if(id1 > id2)
			return 1;
		else if(id1 < id2)
			return -1;
		else
			return 0;
		
	}
	
	
	
	
	
	
}
