package com.revature.dao;

import java.util.List;

import com.revature.model.PendingRequests;

public interface PendingRequestDao {

	List<PendingRequests> getAllPendingRequests();
	PendingRequests getRequestById(int requestId);
	PendingRequests createPendingRequest(PendingRequests pendingRequest);
	PendingRequests updatePendingRequest(PendingRequests toBeUpdated);
	
	//returns number of rows affected
	long deletePendingRequest(PendingRequests... toBeDeleted);
}
