package com.Sprinkle.EMS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageEmployeeRunner extends MainMenuRunner implements Serializable {

	public void menu() {

		int empMenuIn = 0;
		int input;
	
		Address address = new Address(null, null, null, 0);
		Scanner scanner = new Scanner(System.in);
		
		
		do {
			
		
		empMenuIn = Validation
				.checkInt(
						"Manage Employee \n" + "1. Add Employee \n" + "2. Delete Employee \n" + "3. Edit Employee \n"
								+ "4. Show Employee \n" + "5. Show All Employee \n" + "6. Exit \n",
						"Please try again:");
		switch (empMenuIn) {
		
		case 1: // add new
			Employee employee = new Employee();

			int eIndex = 0;

			if (employeeList.size() > 0) {
				eIndex = employeeList.get(employeeList.size() - 1).getEmployeeID() + 1;
			}

			employee.setEmployeeID(eIndex);
			eIndex++;
			employee.setName(Validation.checkString("Enter name", "Please try again:"));
			employee.setAge(Validation.checkInt("Enter Age", "Please try again:"));
			employee.setEmail(Validation.checkString("Enter Email", "Please try again:"));
			employee.setStartDate(Validation.checkString("Enter Start Date", "Please try again:"));
			employee.setPayRate(Validation.checkDbl("Enter Pay Rate", "Please try again:"));
			address.setStreet(Validation.checkString("Enter Home Address \nEnter Street", "Please try again:"));
			address.setCity(Validation.checkString("Enter City", "Please try again:"));
			address.setState(Validation.checkString("Enter State", "Please try again:"));
			address.setZip(Validation.checkInt("Enter Zip", "Please try again:"));
			employee.setAddress(address);
			System.out.println("Types of Employment\n" + "1.Fulltime \n" + "2.Part Time \n" + "3.Contract");
			employee.setTypeOfEmployment(Validation.checkTypeOfEmployment("Enter Employment Type", "Please try again:") - 1);
			// add check for bounds
			employee.setEmergencyContact(
					Validation.checkInt("Enter Emergency Contact Phone Number", "Please try again:"));
			employee.setPosition(Validation.checkString("Enter Position", "Please try again:"));
			int indexN;
			for (int i = 0; i < departmentList.size(); i++) {
				indexN = i + 1;
				System.out.println(indexN + ".   " + departmentList.get(i).getDepartmentName());
			}

			while (true) {
				int inputD = Validation.checkDepartment(departmentList,"Please choose Employee Department number option From List Above",
						"Input is incorrect");
				if (inputD <= departmentList.size() && inputD > 0) {
					employee.setDepartment(departmentList.get(inputD - 1));
					break;
				} else {
					System.out.println("That Department number is invalid");

				}
			}

			employee.setManager(Validation.checkString("Enter Manager Name/ID", "Please try again:"));
			employee.setSsn(Validation.checkSSN("Enter SSN"));
			employee.setPhoneNumber(Validation.checkPhoneNumber("Enter Phone Number"));
			System.out.println(
					"Select your Gender \n" + "1. NotSpecified\n" + "2. Male\n" + "3. Female\n" + "4. Other \n");
			employee.setGender(Validation.checkGender("Enter Gender from above", "Please try again:") - 1);

			int indexB;
			for (int i = 0; i < branchList.size(); i++) {
				indexB = i + 1;
				System.out.println(indexB + ".   " + branchList.get(i).getName());
			}

			while (true) {
				int inputB = Validation.checkBranch(branchList, "Please choose Employee Branch number option from List Above",
						"Input is incorrect");
				if (inputB <= branchList.size() && inputB > 0) {
					employee.setBranch(branchList.get(inputB - 1));
					break;
				} else {
					System.out.println("That Branch number is invalid");

				}
			}

			employeeList.add(employee);

			break;

		case 2: // delete
			 int idNumber = Validation.checkInt("Please enter employee ID number", "invalid employee ID number: ");
	            if (idNumber == Validation.checkInt("Please confirm ID number", "not a valid ID number")) {
	                for (int i = 0; i < employeeList.size(); i++) {
	                    if (employeeList.get(i) != null) {
	                        if (employeeList.get(i).getEmployeeID() == idNumber) {
	                            employeeList.remove(i);
	                            System.out.println("Employee deleted");
	                        }
	                    }
	                }
	            } else {
	                System.out.println("The ID numbers did not match. Deletion NOT completed!!");
	            }
	            break;
		
		
		case 3:// edit
			int id;
			String errMsg = "Please try Again";
			id = Validation.checkInt("Please enter employee ID number", errMsg);
			// is ID is confirmed
			
			boolean checked = false;
			
			for(int i = 0; i < employeeList.size(); i++)
			{
				if( employeeList.get(i).getEmployeeID() == id)
				{
					id = i;
					checked = true;
					break;
				}
			}
			
			
			
			if( checked ) {
				do {
					employee = employeeList.get(id);
					input = Validation.checkInt("Edit Employee" + "\n1. Edit employee name "
							+ "\n2. Edit employee pay rate " + "\n3. Edit employee start date"
							+ "\n4. Edit employee end date" + "\n5. Edit employee Employment Type "
							+ "\n6. Edit employee Emergency Contact" + "\n7. Edit employee Position"
							+ "\n8. Edit employee Manager" + "\n9. Edit employee Department"
							+ "\n10. Edit employee Vacation Time" + "\n11. Edit employee Age" + "\n12. Edit employee SSN"
							+ "\n13. Edit employee Phone Number" + "\n14. Edit employee Gender"
							+ "\n15. Edit employee Address " + "\n16. Edit employee Branch" + "\n17. Edit employee Email"
							+ "\n18. Return to previous Option", "Please Try again");

					switch (input) {
					case 1:
						employee.setName(Validation.checkString("Enter employee new name", "Try again"));
						System.out.println("Updated Name!");
						break;

					case 2:
						employee.setPayRate(Validation.checkInt("Enter new Pay Rate", "Try again"));
						System.out.println("Updated Pay Rate!");
						break;

					case 3:
						employee.setStartDate(Validation.checkString("Enter new Start Date", errMsg));
						System.out.println("Updated Start Date!");
						break;

					case 4:
						employee.setEndDate(Validation.checkString("Enter new Date", errMsg));
						System.out.println("Updated New Date!");
						break;

					case 5:
						do {
							int i = Validation.checkInt("1. Full \n" + "2. Part \n" + "3. Contract", errMsg);
							if (i > 0 && i < 4) {
								employee.setTypeOfEmployment(i - 11);
								break;
							} else
								System.out.println("Invalid selection");
						} while (true);
						System.out.println("Updated Type!");
						break;

					case 6:
						employee.setEmergencyContact(Validation.checkInt("Enter new phone number", errMsg));
						System.out.println("Updated PHone number!");
						break;

					case 7:
						employee.setPosition(Validation.checkString("Enter Position", errMsg));
						System.out.println("Updated Position!");
						break;

					case 8:
						employee.setManager(Validation.checkString("Enter Manager name", errMsg));
						System.out.println("Updated Manager name!");
						break;

					case 9:
						int indexM = 0;
		                   for(int i = 0; i < departmentList.size(); i++)
		                   {
		                       indexM = i + 1;
		                       System.out.println(indexM + ".   " + departmentList.get(i).getDepartmentName());
		                   }

		                   int inputp = Validation.checkInt("Please choose input", "Input is incorrect");

		                   
		                   
		                   
		                   if(inputp <= departmentList.size() && inputp > 0)
		                   {
		                	   employee.setDepartment(departmentList.get(inputp - 1));
		                	   System.out.println("Updated Department!");
		                   }
		                   else
		                   {
		                	   System.out.println("That Department number is invalid");
		                   }
		                   break;
	               
					case 10:
						employee.setVacationTimeRemaining(Validation.checkInt("Enter remaining time", errMsg));
						System.out.println("Updated remaining time!");
						break;

					case 11:
						employee.setAge(Validation.checkInt("Enter age", errMsg));
						System.out.println("Updated age!");
						break;

					case 12:
						employee.setSsn(Validation.checkInt("Enter SSN", errMsg));
						System.out.println("Updated SSN!");
						break;

					case 13:
						employee.setPhoneNumber(Validation.checkPhoneNumber("Enter phone number"));
						System.out.println("Updated PHone Number!");
						break;

					case 14:
						employee.setGender(Validation.checkInt("Enter gender", errMsg));
						System.out.println("Updated Gender");
						break;

					case 15:
						Address a = employee.getAddress();
						int i;
						do {
							i = Validation.checkInt("1. Edit State" + "\n2. Edit City " + "\n3. Edit Street "
									+ "\n4. Edit Zip Code" + "\n5. Exit edit address menu ", null);
							switch (i) {

							case 1:
								a.setState(Validation.checkString("Enter State", errMsg));
								break;

							case 2:
								a.setCity(Validation.checkString("Enter city", errMsg));
								break;

							case 3:
								a.setStreet(Validation.checkString("Enter Street", errMsg));
								break;

							case 4:
								a.setZip(Validation.checkInt("Enter Zip code", errMsg));
								break;
							case 5:
								i = 5;
								break;

							default:
								break;
							}
						} while (i != 5);

						break;		
					case 16:
						int indexBa = 0;
		                   for(int j = 0; j < branchList.size(); j++)
		                   {
		                       indexBa = j + 1;
		                       System.out.println(indexBa + ".   " + branchList.get(j).getName());
		                   }

		                   int inputBa = Validation.checkInt("Please choose input", "Input is incorrect");

		                   
		                   if(inputBa <= branchList.size() && inputBa > 0)
		                   {
		                   employee.setBranch(branchList.get(inputBa - 1));
		                   System.out.println("Updated Branch");
		                   }
		                   else
		                   {
		                	   System.out.println("That Branch number is invalid");
		                   }

		                   break;

					case 17:
						employee.setEmail(Validation.checkString("Enter Email", "Please try again:"));
						System.out.println("Updated Email!");
						break;

					default:
						break;
					}

				} while (input != 18);
			}
			else {
				// can't find employee
				System.out.println("employee don't exist!");
			}
			break;
			
		case 4:// show employee
			do {
				int employeeId = Validation.checkInt("Enter employee ID", "");
				boolean c = false;
				
				for(int i = 0; i < employeeList.size(); i++)
				{
					if( employeeList.get(i).getEmployeeID() == employeeId)
					{
						employeeId = i;
						c = true;
						break;
					}
				}
				
				// assuming some employee's get new id's when Employee get deleted
				if( c ) {
					Employee e = MainMenuRunner.employeeList.get(employeeId);
					//Address a = e.getAddress();
					System.out.println("Name: "+ e.getName());
		            System.out.println("Age: "+ e.getAge());
		           // System.out.println("Street: "+a.getStreet()+" State: "+a.getState()+" City: "+a.getCity());
		            System.out.println("Employee ID: "+ e.getEmployeeID());
		            break;
				}
				else {
					// can't find employee
					System.out.println("employee don't exist!");
					break;
				}
			}
			while(true);			
			break;
		case 5:// show all//methods created 
			if( MainMenuRunner.employeeList.isEmpty() ) 
				System.out.println("We currently dont have any empolyees.");
			else {
				for(Employee e:employeeList) {
						
					
					System.out.println("Name: "+ e.getName());
	                System.out.println("Age: "+ e.getAge());
	                if(e.getBranch()!=null) {System.out.println("Branch: "+ e.getBranch().getName());}
	                if(e.getDepartment()!=null) {System.out.println("Department: "+ e.getDepartment().getDepartmentName());}
	                System.out.println("Employee ID: "+ e.getEmployeeID());
	                System.out.println("------------------------------------------------");
				}
			}
			break;
			
		case 6:// exit

			break;
		default:
			break;
		}
		}while(empMenuIn != 6);

	}

}
