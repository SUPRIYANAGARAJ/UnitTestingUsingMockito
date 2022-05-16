package com.skillsoft.Mocks_Project21;

public class Employee {
	
	private String name;
	private String designation;
	private int salary;
	
	public Employee(String name, String designation, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
    
	public String getDesignation() {
		return designation;
	}
   
	public int getSalary() {
		return salary;
	}

	public boolean saveToDatabase(String connectionString) {
		
		//NOTE: Assume that this method connects to a database and stores the data
		//of this employee
		
		return true;
	}
	
    public boolean deleteFromDatabase(String connectionString) {
		
		//NOTE: Assume that this method connects to a database and deletes the data
		//of this employee
		
		return true;
	}
	
	
	
	

}
