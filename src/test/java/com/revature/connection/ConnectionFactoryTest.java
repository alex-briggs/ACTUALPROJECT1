package com.revature.connection;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImplementation;
import com.revature.model.Employee;


public class ConnectionFactoryTest {

	private EmployeeDao dao = new EmployeeDaoImplementation();
		
	
	@Test
	public void getAllEmployeesShouldReturn1() {
		List<Employee> employees = dao.getAllEmployees();
		System.out.println(employees);
		assertEquals(1, employees.size());
	}
	
}
