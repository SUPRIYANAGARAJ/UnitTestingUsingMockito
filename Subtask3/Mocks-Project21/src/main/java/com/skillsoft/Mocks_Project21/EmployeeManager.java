package com.skillsoft.Mocks_Project21;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	
	private List<Employee> employeesList = new ArrayList<>();
	private String databaseConnectionString;
	
	public EmployeeManager(String databaseConnectionString) {
		super();
		this.databaseConnectionString = databaseConnectionString;
	}
	
	public void addEmployee(Employee employee) {
		employeesList.add(employee);
		
		employee.saveToDatabase(databaseConnectionString);
	}
	
	public void removeEmployeeByName(String name) {
		
		for(Employee e : employeesList) {

			if(e.getName().equals(name)) {

			employeesList.remove(e);
			e.deleteFromDatabase(databaseConnectionString);

			break;
			}
			}
	}
	
	public boolean employeeExists(String name) {
		for(Employee e : employeesList) {
			if(e.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
}
	
	
	