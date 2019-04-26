package com.revature.model;

public class Managers {
	private int managerId;
	private String managerFirstName;
	private String managerLastName;
	private String managerUserName;
	private String managerPassword;
	private int departmentNumber;
	
	public Managers() {
		
	}

	public Managers(int managerId, String managerFirstName, String managerLastName, String managerUserName,
			String managerPassword, int departmentNumber) {
		super();
		this.managerId = managerId;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerUserName = managerUserName;
		this.managerPassword = managerPassword;
		this.departmentNumber = departmentNumber;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public String getManagerUserName() {
		return managerUserName;
	}

	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentNumber;
		result = prime * result + ((managerFirstName == null) ? 0 : managerFirstName.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((managerLastName == null) ? 0 : managerLastName.hashCode());
		result = prime * result + ((managerPassword == null) ? 0 : managerPassword.hashCode());
		result = prime * result + ((managerUserName == null) ? 0 : managerUserName.hashCode());
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
		Managers other = (Managers) obj;
		if (departmentNumber != other.departmentNumber)
			return false;
		if (managerFirstName == null) {
			if (other.managerFirstName != null)
				return false;
		} else if (!managerFirstName.equals(other.managerFirstName))
			return false;
		if (managerId != other.managerId)
			return false;
		if (managerLastName == null) {
			if (other.managerLastName != null)
				return false;
		} else if (!managerLastName.equals(other.managerLastName))
			return false;
		if (managerPassword == null) {
			if (other.managerPassword != null)
				return false;
		} else if (!managerPassword.equals(other.managerPassword))
			return false;
		if (managerUserName == null) {
			if (other.managerUserName != null)
				return false;
		} else if (!managerUserName.equals(other.managerUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", managerFirstName=" + managerFirstName + ", managerLastName="
				+ managerLastName + ", managerUserName=" + managerUserName + ", managerPassword=" + managerPassword
				+ ", departmentNumber=" + departmentNumber + "]";
	}
	
	
}
