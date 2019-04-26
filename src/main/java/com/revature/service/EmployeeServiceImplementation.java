package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImplementation;
import com.revature.model.Employee;


public class EmployeeServiceImplementation implements EmployeeService {

	private final EmployeeDao employeeDao = new EmployeeDaoImplementation();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee createEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Employee employee = mapper.readValue(request.getInputStream(), Employee.class);
			return employeeDao.createEmployee(employee);
		} catch (IOException e) {
			return null;
		}
	
		
	}

	@Override
	public Employee updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByUserNameAndPassword(HttpServletRequest request, HttpServletResponse response) {
		Employee employee;
		try {
			employee = mapper.readValue(request.getInputStream(), Employee.class);
			String username = employee.getEmployeeUserName();
			String password = employee.getEmployeePassword();
			return employeeDao.getEmployeeByUserNameAndPassword(username, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
