package com.Sprinkle.EMS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
public class Employee extends Person implements LaborLaws, Serializable {
    private int employeeID;
    private String startDate;
    private String endDate;
    private double payRate;
    private String position;
    private String manager;
    private Department department;
    private enum typesOfEmployment{Fulltime, Parttime,Contract;}
    private typesOfEmployment typeOfEmployment;
    private int emergencyContact;
 	private int vacationTimeRemaining;
    private static int employeeIDIndex=0;
    private Branch branch;
    
    public Employee() {
        this.employeeID=0;
        this.department=null;
        this.position="Default";
        setAge(0);
        ;
        setName("Default");
        this.position="Default";
        this.vacationTimeRemaining=0;
        this.typeOfEmployment=null;
        setGender(0);
        setPhoneNumber(0);
        setSsn(0);
        this.manager="Default";
        this.emergencyContact=0;
    }
    public void setDepartment(Department d) {
        this.department = d;
        }
    
    
    public void addEmployee(Employee[] eArr, Department[] dArr, Branch[] bArr, int age, String name, int departmentID, String startDate, String endDate, int typeOfEmployment, Address address, int gender, int phone, int branchID, double payRate, String position, int ssn) {
        for(int i=0;i<eArr.length;i++) {
            if(eArr[i].getAge()==0) {
                eArr[i]=new Employee();
                if(age>=LaborLaws.minAge) {
                    eArr[i].setAge(age);
                }else{
                    System.out.println("Age too low, cannot add employee");
                    continue;
                }
                if(payRate>=LaborLaws.minPayRate) {
                    eArr[i].setPayRate(payRate);
                }else{
                    System.out.println("Pay too low, cannot add employee");
                    continue;
                }
                eArr[i].setName(name);
                eArr[i].setAddress(address);
                eArr[i].setEmployeeID(employeeID);
                eArr[i].setStartDate(startDate);
                eArr[i].setEndDate(endDate);
                eArr[i].setPhoneNumber(phone);
                eArr[i].setGender(gender);
                eArr[i].setDepartment(departmentID,dArr);
                eArr[i].setBranch(bArr,branchID);
                eArr[i].setPayRate(payRate);
                eArr[i].setPosition(position);
                eArr[i].setSsn(ssn);
                eArr[i].setTypeOfEmployment(typeOfEmployment);
                break;
            }
        }
        System.out.println("Employee successfully added");
    }
    
    public static void displayEmployee(Employee[] eArr, int employeeID) {
        for(int i=0;i<eArr.length;i++) {
        	if(eArr[i] !=null ) {
             if (eArr[i].employeeID==employeeID) {
            	 Address address = eArr[i].getAddress();
                 System.out.println("Name: "+ eArr[i].getName());
                 System.out.println("Age: "+ eArr[i].getAge());
                 System.out.println("Street: "+address.getStreet()+" State: "+address.getState()+" City: "+address.getCity());
                 System.out.println("Employee ID: "+ eArr[i].getEmployeeID());
                 System.out.println();
             }
             }
         }
    }
    
    public static void displayAllEmployees(Employee[] eArr) {
        for(int i=0;i<eArr.length;i++) {
             if (eArr[i] != null) {
            	 Address address = eArr[i].getAddress();
                 System.out.println("Name: "+ eArr[i].getName());
                 System.out.println("Age: "+ eArr[i].getAge());
                 System.out.println("Street: "+address.getStreet()+" State: "+address.getState()+" City: "+address.getCity());
                 System.out.println("Employee ID: "+ eArr[i].getEmployeeID());
                 System.out.println("------------------------------------------------");
             }
        }
    }
    
    public static void removeEmployee(int employeeID, Employee[] eArr) {
                 eArr[employeeID]=null;
    }
    
    public static void editName(int employeeID, Employee[] eArr, String newName) {
        for(int i=0;i<eArr.length;i++) {
             if (eArr[i].employeeID==employeeID) {
                 eArr[i].setName(newName);
             }
        }
    }
    public static void editEmployeeStartDate(int employeeID, Employee[] eArr, String newStartDate ) {
        for(int i=0;i<eArr.length;i++) {
             if (eArr[i].employeeID==employeeID) {
                 eArr[i].setStartDate(newStartDate);
                 }
        }
    }
    public static void editEmployeeEndDate(int employeeID, Employee[] eArr, String newEndDate) {
        for(int i=0;i<eArr.length;i++) {
             if (eArr[i].employeeID==employeeID) {
                 eArr[i].setEndDate(newEndDate);
                 }
        }
    }
    public static void editPayRate(int employeeID, Employee[] eArr, double payRate) {
        for(int i=0;i<eArr.length;i++) {
             if (eArr[i].employeeID==employeeID) {
                 if(payRate>=LaborLaws.minPayRate) {
                        eArr[i].setPayRate(payRate);
                    }else{
                        System.out.println("Pay too low, cannot edit employee");
                        break;
                    }
                 }
        }
    }
    public void setTypeOfEmployment(int typeOfEmployment) {
        typesOfEmployment[] t= typesOfEmployment.values();
        this.typeOfEmployment=t[typeOfEmployment];
    }
    public typesOfEmployment getTypeOfEmployment() {
        return this.typeOfEmployment;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
    }
    public String getStartDate() {
            return startDate;
    }
    public void setStartDate(String string) {
            this.startDate = string;
    }
    public String getEndDate() {
            return endDate;
    }
    public void setEndDate(String endDate) {
            this.endDate = endDate;
    }
    public double getPayRate() {
            return payRate;
    }
    public void setPayRate(double payRate) {
            this.payRate = payRate;
    }
    public String getPosition() {
            return position;
    }
    public void setPosition(String position) {
            this.position = position;
    }
    public String getManager() {
            return manager;
    }
    public void setManager(String string) {
            this.manager = string;
    }
    public Department getDepartment() {
    		
            return this.department;
    }
    public void setDepartment(int departmentID, Department[] dArr) {
            for(int i=0; i<dArr.length; i++) {
                if(dArr[i].getDepartmentID()==departmentID) {
                    this.department=dArr[i];
                    break;
                }
            }
    }
    
    public int getVacationTimeRemaining() {
            return vacationTimeRemaining;
    }
    public void setVacationTimeRemaining(int vacationTimeRemaining) {
            this.vacationTimeRemaining = vacationTimeRemaining;
    }
    public void setBranch(Branch[] bArr, int branchID) {
        for(int i=0;i<bArr.length;i++){
            if(bArr[i].getBranchId()==branchID) {
                this.branch=bArr[i];
                break;
            }
        }
    }
  public void setBranch(Branch b) {
    	
    	this.branch = b;
  }
  
    public Branch getBranch() {
        return this.branch;
    }
  
    public int getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(int emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	 public static void displayAllEmployees(ArrayList<Employee> employeeList) {
	    	if( employeeList.isEmpty() ) 
				System.out.println("We currently dont have any empolyees.");
			else {
		    	for( Employee e: employeeList ) {
					Address address = e.getAddress();
					System.out.println("Name: "+ e.getName());
	                System.out.println("Age: "+ e.getAge());
	                System.out.println("Street: "+address.getStreet()+" State: "+address.getState()+" City: "+address.getCity());
	                System.out.println("Employee ID: "+ e.getEmployeeID());
	                System.out.println("------------------------------------------------");
				}
		    	}
			}
			
	
	public static void displayEmployee(ArrayList<Employee> employeeList, int id) {
		if( id<employeeList.size() && id >= 0 ) {
			Employee e = employeeList.get(id);
			Address address = e.getAddress();
			System.out.println("Name: "+ e.getName());
            System.out.println("Age: "+ e.getAge());
            System.out.println("Street: "+address.getStreet()+" State: "+address.getState()+" City: "+address.getCity());
            System.out.println("Employee ID: "+ e.getEmployeeID());
		}
		else
			System.out.println("employee don't exist!");
		
	}
        
}