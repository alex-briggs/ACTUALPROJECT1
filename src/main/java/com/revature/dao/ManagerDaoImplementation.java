package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.model.Managers;
import com.revature.util.ConnectionFactory;

public class ManagerDaoImplementation implements ManagerDao {

	@Override
	public List<Managers> getAllManagers() {
		List<Managers> managers = new ArrayList<>();
		//Get our connection 
		try (Connection conn = ConnectionFactory.getConnection()){
			//create statement to communicate with database
			Statement stmt = conn.createStatement();
			//execute statement, all matched records can be found in the ResultSet
			ResultSet rs = stmt.executeQuery("SELECT * FROM managers");
			//populate list of managers from the ResultSet
			while (rs.next()) {
				managers.add(new Managers(rs.getInt("manager_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("emp_user_name"), rs.getString("emp_password"), rs.getInt("dept_no")));
			}
			//Return managers so that the application can further manipulate
			return managers;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Managers getManagerById(int managerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Managers createManager(Managers manager) {
		//get connection to data source
		try (Connection conn = ConnectionFactory.getConnection()){
			//preparedStatement to avoid sql injections
			//initialize our insert statement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO managers VALUES (?,?,?,?,?,?)");
			//set the values of the insert statement to help prevent SQL injection
			stmt.setInt(1, manager.getManagerId());
			stmt.setString(2, manager.getManagerFirstName());
			stmt.setString(3, manager.getManagerLastName());
			stmt.setString(4, manager.getManagerUserName());
			stmt.setString(5, manager.getManagerPassword());
			stmt.setInt(6, manager.getDepartmentNumber());
			//execute the query, determining the number of rows that were affected
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected == 1) {
				return manager;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return new Managers();
	}

	@Override
	public Managers updateManager(Managers toBeUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteManager(Managers... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
