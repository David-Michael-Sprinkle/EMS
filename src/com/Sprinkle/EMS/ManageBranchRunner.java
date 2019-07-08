package com.Sprinkle.EMS;

import java.io.Serializable;

public class ManageBranchRunner extends MainMenuRunner implements Serializable {

	public void menu() {

		int index = branchList.get(branchList.size() - 1).getBranchId() + 1;
		int input;
		int branchMenuIn;
		Branch branch = new Branch();
		do {
			branchMenuIn = Validation.checkInt("Manage branch Select from the following optionn to manage bracnh\n"
					+ "1. Add Branch\n" + "2. Show a Branch\n" + "3. Show all Branches\n" + "4. Delete Branch\n"
					+ "5. Edit Branch\n" + "6. Exit to main menu", null);
			switch (branchMenuIn) {
			case 1: // Add branch
				branch.setBranchId(index);
				String name = Validation.checkString("Enter Branch name", "Please try again:");
				long phone = Validation.checkPhoneNumber("Please enter phone number");
				String address = Validation.checkString("Enter Branch address", "Please try again:");
				String type = Validation.checkString("Enter Branch type\" Small, Medium, or HQ\"", "Please try again:");
				branchList.add(new Branch(name, index, address, phone, type));
				index++;
				break;
			case 2:// show a selected branch
				int input2 = Validation.checkInt("Please input Branch ID", "Enter a valid number");

				for (int i = 0; i < branchList.size(); i++) {

					if (input2 == branchList.get(i).getBranchId()) {
						System.out.println("\tID: " + branchList.get(i).getBranchId() + "Name: "
								+ branchList.get(i).getName() + "Phone number: " + branchList.get(i).getPhone()
								+ "\tLocation: " + branchList.get(i).getAddress());
						break;
					}
				}
				break;

			case 3: // show all branch
				System.out.println("Display all Branch");
				for (Branch x : branchList)
					if (x != null)
						System.out.println("Identifier: " + x.getBranchId() + "\tName: \t" + x.getName()
								+ "\tPhone Number: \t" + x.getPhone() + "\tAddress: \t" + x.getAddress());
				break;

			case 4: // delete branch
				int indexBA = Validation.checkInt("Enter the branch id", "Please input integer");
				boolean checkBA = false;
				int removeBA = 0;

				for (int i = 0; i < branchList.size(); i++) {
					if (branchList.get(i).getBranchId() == indexBA) {
						System.out.println(branchList.get(i));
						removeBA = i;
						checkBA = true;
						break;
					}
				}

				if (checkBA) {

					String confirm = Validation.checkString(
							"Please confirm with 'yes' or 'no' if you wish to delete this branch3",
							"Please input the lower case word 'yes' or 'no'");
					String yesConfirm = "yes";
					String noConfirm = "no";

					if (confirm.equals(yesConfirm)) {

						branchList.remove(removeBA);
						System.out.println("Branch has been deleted");
					} else if (confirm.equals(noConfirm)) {
						System.out.println("Branch has not been deleted");
					} else {
						System.out.println("Please try again the input is invalid");
					}
				} else {
					System.out.println("Branch id is not valid");
				}
				break;

			case 5: // enter ID to Edit

				int editMenu = -1;
				int editID = Validation.checkInt("Enter Branch ID to Edit: ", "Please Try Again");

				do {

					editMenu = Validation.checkInt(
							"Select from the following to edit this branch\n" + "1.Edit name\n" + "2.Edit Number\n"
									+ "3.Edit Address\n" + "4.Edit Type\n" + "5.Exit\n" + "6. Exit to main menu",
							"Please Try Again");
					// new switch case edit menu
					
					for (int i = 0; i < branchList.size(); i++) {
						if (branchList.get(i).getBranchId() == editID) {
							editID = i;
							break;
						}
					}
					
					switch (editMenu) {
					case 1:// name
						branchList.get(editID).setName(Validation.checkString("Enter New Name:", "Please Try Again: "));
						break;

					case 2:// Phone number
						branchList.get(editID).setPhone(Validation.checkInt("Enter New Number", "Please Try Again: "));
						break;
					case 3:// Address
						branchList.get(editID)
								.setAddress(Validation.checkString("Enter New Address:", "Please Try Again: "));
						break;

					case 4:// Type
						branchList.get(editID).setType(Validation.checkString("Enter New Type:", "Please Try Again: "));
						break;
					case 5:
						break;
					default:
						break;
					}

				} while (editMenu != 5);

				break;

			case 6: // edit
				break;
			default:

				break;
			}
		} while (branchMenuIn != 6);
	}

}