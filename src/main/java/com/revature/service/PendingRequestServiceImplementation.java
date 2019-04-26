package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.PendingRequestDao;
import com.revature.dao.PendingRequestDaoImplementation;
import com.revature.model.PendingRequests;

public class PendingRequestServiceImplementation implements PendingRequestService {

	private final PendingRequestDao pendingRequestDao = new PendingRequestDaoImplementation();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<PendingRequests> getAllPendingRequests(HttpServletRequest request, HttpServletResponse response) {
		return pendingRequestDao.getAllPendingRequests();
	}

	@Override
	public PendingRequests createPendingRequest(HttpServletRequest request, HttpServletResponse response) {
		
			System.out.println("inside createPendingRequest");
			System.out.println(request.getParameterMap().toString());
			PendingRequests pendingRequest = new PendingRequests(Integer.parseInt(request.getParameter("requestId")), request.getParameter("reason"), request.getParameter("status"), Integer.parseInt(request.getParameter("reimbursementAmount")));
			System.out.println("created pendingRequest");
			return pendingRequestDao.createPendingRequest(pendingRequest);
		
	}

	@Override
	public PendingRequests updatePendingRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("inside updatePendingRequest");
			PendingRequests toBeUpdated = mapper.readValue(request.getInputStream(), PendingRequests.class);
			System.out.println("updated Request");
			return pendingRequestDao.updatePendingRequest(toBeUpdated);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("inside exception: returning null");
			
			return null;
		}
	}

	
}
