package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.model.PendingRequests;

public interface PendingRequestService {

	List<PendingRequests> getAllPendingRequests(HttpServletRequest request, HttpServletResponse response);
	
	PendingRequests createPendingRequest(HttpServletRequest request, HttpServletResponse response);
	PendingRequests updatePendingRequest(HttpServletRequest request, HttpServletResponse response);
}
