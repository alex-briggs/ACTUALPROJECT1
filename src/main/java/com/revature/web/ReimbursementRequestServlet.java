package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.PendingRequestService;
import com.revature.service.PendingRequestServiceImplementation;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementRequestServlet extends HttpServlet{

	private final PendingRequestService requests = new PendingRequestServiceImplementation();
	private static final long serialVersionUID = 1L;
	
	//private static final ObjectMapper mapper = new ObjectMapper();
	
	
	public ReimbursementRequestServlet() {
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside reimbursementrequestServlet");
		//response.setContentType("application/json");
		//response.getOutputStream().write(mapper.writeValueAsBytes(ReimbursementRequest.processPost(request, response)));
		//request.getRequestDispatcher("/").forward(request, response);
		//String reqUri = request.getRequestURI();
		requests.createPendingRequest(request, response);
		System.out.println("Post Response sent successfully");
		response.sendRedirect("EmployeeHomePage.html");
	}

}
