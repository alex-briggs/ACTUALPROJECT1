package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FrontControllerServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	private final ObjectMapper mapper = new ObjectMapper(); //converts data type to JSON
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		//getOutputStream() because it will write the response more efficiently than getWriter().println()
		//mapper.writeValueAsBytes() converts whatever the Dispatcher returns into a byte[], which getOutPutStream() accepts
		// Dispatcher.process() returns whatever resource we have available at the HttpServletRequest's URI
		resp.getOutputStream().write(mapper.writeValueAsBytes(FrontController.processGet(req, resp)));
	}
	
	
	  @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	  resp) throws ServletException, IOException {
	  resp.setContentType("application/json");
	  resp.getOutputStream().write(mapper.writeValueAsBytes(FrontController.processPost(req, resp))); }
	 
}
