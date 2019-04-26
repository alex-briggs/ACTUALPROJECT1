package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImplementation;
import com.revature.model.Managers;

public class ManagerLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final ObjectMapper mapper = new ObjectMapper();
	private static final ManagerDao managerDao = new ManagerDaoImplementation();

	public ManagerLoginServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("ManagerUserName");
		String password = request.getParameter("ManagerPassword");
		
		//list of managers from SQL (dao)
		List<Managers> managers = managerDao.getAllManagers();
		System.out.println(managers);
		
		//check html for null
		if(username == null || username.equals("") || password == null || password.equals("")) {
			response.getOutputStream().write(mapper.writeValueAsBytes("Please fill out proper credentials"));
		}
		else if(username.equals(managers.get(0).getManagerUserName()) || username.equals(managers.get(1).getManagerUserName())) {
			System.out.println("Employee user name found");
			if (password.equals(managers.get(0).getManagerPassword()) || password.equals(managers.get(1).getManagerPassword())) {
				System.out.println("password found");
				response.sendRedirect("ManagerHomePage.html");
			}
		}
		else {
			System.out.println("Wrong credentials bitch");
			response.sendRedirect("index.html");
		}
	}

}
