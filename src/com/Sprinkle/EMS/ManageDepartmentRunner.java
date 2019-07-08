package com.Sprinkle.EMS;

import java.io.Serializable;

public class ManageDepartmentRunner extends MainMenuRunner implements Serializable{
    
	public void menu() {

		int indexDA;
		boolean checkDA;
		
		int input = 0;
		int depMenuIn = 0;
		int index = departmentList.get(departmentList.size() - 1).getDepartmentID() + 1;
		
		do {

			depMenuIn = Validation.checkInt(
				"Please enter a input \n 1. Add new department \n 2. Delete department \n 3. Rename department"
						+ "\n 4. Show one department \n 5. Show all department \n 6. Exit",
				"Please input integer");

		switch (depMenuIn) {
		case 1:
			String name = Validation.checkString("Enter the department name", "Please check the name input");
			departmentList.add(new Department(index, name));
			index++;

			break;
		case 2:

			indexDA = Validation.checkInt("Enter the department id", "Please input integer");
			checkDA = false;
			int removeDA = 0;
			

			for (int i = 0; i < departmentList.size(); i++) {
				if (departmentList.get(i).getDepartmentID() == indexDA) {
					System.out.println(departmentList.get(i));
					removeDA = i;
					checkDA = true;
					break;
				}
			}

			if (checkDA) {

				String confirm = Validation.checkString(
						"Please confirm with 'yes' or 'no' if you wish to delete this department",
						"Please input the lower case word 'yes' or 'no'");
				String yesConfirm = "yes";
				String noConfirm = "no";
				
				if (confirm.equals(yesConfirm)) {
					
					departmentList.remove(removeDA);
					System.out.println("Department has been deleted");
				} else if (confirm.equals(noConfirm)) {
					System.out.println("Department has not been deleted");
				} else {
					System.out.println("Please try again the input is invalid");
				}
			} else {
				System.out.println("Department id is not valid");
			}
			break;
		case 3:
			indexDA = Validation.checkInt("Enter the department id", "Please input integer");
			checkDA = false;
			int updateDA = 0;

			for (int i = 0; i < departmentList.size(); i++) {
				if (departmentList.get(i).getDepartmentID() == indexDA) {
					System.out.println(departmentList.get(i));
					checkDA = true;
					updateDA = i;
					break;
				}
			}

			if (checkDA) {
				String confirm = Validation.checkString(
						"Please confirm with 'yes' or 'no' if you wish to delete this department",
						"Please input the lower case word 'yes' or 'no'");

				String yesConfirm = "yes";
				String noConfirm = "no";

				if (confirm.equals(yesConfirm)) {
					String namesDAs = Validation.checkString("Please enter department name", "Please input the name");
					departmentList.get(updateDA).setDepartmentName(namesDAs);

				} else if (confirm.equals(noConfirm)) {
					System.out.println("Department has not been updated");
				} else {
					System.out.println("Please try again the input is invalid");
				}
			} else {
				System.out.println("Department id is not valid");
			}

			break;
			
		case 4:
			
			boolean checkDr = false;
			
			int inputDr = Validation.checkInt("Please input number", "Only integer accepted");
			for (int i = 0; i < departmentList.size(); i++) {
				if (departmentList.get(i) != null)
					
					if(inputDr == departmentList.get(i).getDepartmentID())
					{
					System.out.println(departmentList.get(i));
					checkDr = true;
					break;
					}
			}
			
			if(!checkDr)
			{
				System.out.println("Department not found");
			}
			
			break;
		case 5:
			for (int i = 0; i < departmentList.size(); i++) {
				if (departmentList.get(i) != null)
					System.out.println(departmentList.get(i));
			}
			break;
		case 6:
			break;
		default:
			input = 0;
			System.out.println("That is not a valid input");
			break;
		}
		}while(depMenuIn != 6);
	}

}