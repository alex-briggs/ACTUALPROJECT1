package com.revature.model;

public class PendingRequests {

	private int requestId;
	private String status;
	private String reason;
	private int reimbursementAmount;

	
	public PendingRequests() {
		
	}


	public PendingRequests(int requestId, String status, String reason, int reimbursementAmount) {
		super();
		this.requestId = requestId;
		this.status = "pending";
		this.reason = reason;
		this.reimbursementAmount = reimbursementAmount;
	}


	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public int getReimbursementAmount() {
		return reimbursementAmount;
	}


	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimbursementAmount;
		result = prime * result + requestId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PendingRequests other = (PendingRequests) obj;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursementAmount != other.reimbursementAmount)
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PendingRequests [requestId=" + requestId + ", status=" + status + ", reason=" + reason
				+ ", reimbursementAmount=" + reimbursementAmount + "]";
	}

	

	
	
	
}
