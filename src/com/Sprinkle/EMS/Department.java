package com.Sprinkle.EMS;

import java.io.Serializable;

public class Department implements Serializable {
	
	private String departmentName;
	private int departmentID;

	public Department(int departmentID,String departmentName) {
		this.departmentName = departmentName;
		this.departmentID = departmentID;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", departmentID=" + departmentID + "]";
	}
	
}