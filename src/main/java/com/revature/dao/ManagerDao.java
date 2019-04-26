package com.revature.dao;

import java.util.List;

import com.revature.model.Managers;

public interface ManagerDao {
	//CRUD methods 
		List<Managers> getAllManagers();
		Managers getManagerById(int managerId);
		Managers createManager(Managers manager);
		Managers updateManager(Managers toBeUpdated);
		
		//returns number of rows affected
		long deleteManager(Managers... toBeDeleted); 

}
