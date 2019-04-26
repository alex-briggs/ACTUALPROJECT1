package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {

	//CRUD methods 
	List<Employee> getAllEmployees();
	Employee getEmployeeByUserNameAndPassword(String username, String password);
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee toBeUpdated);
	
	//returns number of rows affected
	long deleteEmployee(Employee... toBeDeleted); 
}
