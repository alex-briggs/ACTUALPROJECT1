package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.PendingRequestService;
import com.revature.service.PendingRequestServiceImplementation;

public class ReimbursementRequest {

	private static final PendingRequestService pendingRequestService = new PendingRequestServiceImplementation();
	
	//Restrict instantiation
	private ReimbursementRequest() {};
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		return pendingRequestService.getAllPendingRequests(request, response);
	}
	
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside reimbursementrequest");
		return pendingRequestService.createPendingRequest(request, response);
	}
}
