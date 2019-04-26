package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImplementation;
import com.revature.model.Employee;



/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final EmployeeDao employeeDao = new EmployeeDaoImplementation();

    public EmployeeLoginServlet() {
        super();
       
    }


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		
		//list of employees from SQL (dao)
		List<Employee> employees = employeeDao.getAllEmployees();
		System.out.println(employees);
		
		//check html for null
		if(username == null || username.equals("") || password == null || password.equals("")) {
			response.getOutputStream().write(mapper.writeValueAsBytes("Please fill out proper credentials"));
		}
		else if(username.equals(employees.get(0).getEmployeeUserName()) || username.equals(employees.get(1).getEmployeeUserName())) {
			System.out.println("Employee user name found");
			if (password.equals(employees.get(0).getEmployeePassword()) || password.equals(employees.get(1).getEmployeePassword())) {
				System.out.println("password found");
				response.sendRedirect("EmployeeHomePage.html");
			}
		}
		else {
			System.out.println("Wrong credentials bitch");
			response.sendRedirect("index.html");
		}
		
	}

}
