package com.Sprinkle.EMS;

import java.io.Serializable;

public class Branch implements Serializable {
	private String name;
	private int branchId;
	private String address;
	private long phone;
	private String type;
	
	
	
	public Branch(String name, int branchId, String address, long phone, String type) {
		super();
		this.name = name;
		this.branchId = branchId;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}
	
	public Branch() {
		
	}
	@Override
	public String toString() {
		return "Branch [name=" + name + ", branchId=" + branchId + ", address=" + address + ", phone=" + phone
				+ ", type=" + type + "]";
	}

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	
	// Small/Med/LG/HQ
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void removeBranch(Branch[] branchList) {
		int idNumber=Validation.checkInt("Please enter Branch ID number", "invalid Branch ID number: ");
		
		if(idNumber==Validation.checkInt("Please confirm Branch ID number", "invalid Branch ID number: ")) {
			if(branchList[idNumber]!=null)
				branchList[idNumber] = null;
			else
				System.out.println("There no Branch with ID: "+idNumber);
		}
		else 
			System.out.println("Branch ID numbers do not match, cannot delete Branch");
	}
	
	public void editBranch(Branch[] branchList) {
		int idNumber=Validation.checkInt("Please enter Branch ID number", "invalid Branch ID number: ");
		int input;
		if(idNumber==Validation.checkInt("Please confirm Branch ID number", "invalid Branch ID number: ")) {
			if(branchList[idNumber]!=null) {
				do {
					input = Validation.checkInt("Edit Employee"
							+"\n1. Edit name "
							+"\n2. Edit address "
							+"\n3. Edit phone number"
							+"\n4. Edit type"
							+"\n5. Exit edit branch menu ", null);
					switch (input) {
					case 1:
						branchList[idNumber].setName(Validation.checkString("Please eneter Branch name", null));
						break;
						
					case 2:
						branchList[idNumber].setAddress(Validation.checkString("Please enter address", null));
						break;
					case 3:
						branchList[idNumber].setPhone(Validation.checkInt("Please enter phone number", null));
						break;
					case 4:
						branchList[idNumber].setType(Validation.checkString("Please enter type", null));
						break;
						
					default:
						break;
					}
				}while(input!=5);
			}
			else
				System.out.println("There no Branch with ID: "+idNumber);
		}
		else 
			System.out.println("Branch ID numbers do not match, cannot delete Branch");
	}
	
}