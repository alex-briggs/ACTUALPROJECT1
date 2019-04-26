package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDaoImplementation implements EmployeeDao {

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		// Get our connection
		try (Connection conn = ConnectionFactory.getConnection()) {
			// create statement to communicate with database
			Statement stmt = conn.createStatement();
			// execute statement, all matched records can be found in the ResultSet
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			// populate list of employees from the ResultSet
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("emp_user_name"), rs.getString("emp_password"), rs.getInt("dept_no"),
						rs.getInt("manager_id")));
				
			}
			System.out.println(employees);
			// Return employees so that the application can further manipulate
			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employee getEmployeeByUserNameAndPassword(String username, String password) {

		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {

		// get connection to data source
		try (Connection conn = ConnectionFactory.getConnection()) {
			// preparedStatement to avoid sql injections
			// initialize our insert statement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?,?,?)");
			// set the values of the insert statement to help prevent SQL injection
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getEmployeeFirstName());
			stmt.setString(3, employee.getEmployeeLastName());
			stmt.setString(4, employee.getEmployeeUserName());
			stmt.setString(5, employee.getEmployeePassword());
			stmt.setInt(6, employee.getDepartmentNumber());
			stmt.setInt(7, employee.getManagerId());
			// execute the query, determining the number of rows that were affected
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1) {
				return employee;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return new Employee();
	}

	@Override
	public Employee updateEmployee(Employee toBeUpdated) {

		return null;
	}

	@Override
	public long deleteEmployee(Employee... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
