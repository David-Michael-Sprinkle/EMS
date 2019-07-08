package com.Sprinkle.EMS;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuRunner  {
	
	
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static ArrayList<Department> departmentList = new ArrayList<Department>();
	public static ArrayList<Branch> branchList = new ArrayList<Branch>();
	
	public static void main(String[] args) {
		ManageEmployeeRunner manageEmployeeRunner = new ManageEmployeeRunner();
		ManageBranchRunner manageBranchRunner = new ManageBranchRunner();
		ManageDepartmentRunner manageDepartmentRunner = new ManageDepartmentRunner();
		Address a = new Address("Default","Default","Default",00000);
		Branch b = new Branch("StreetLabs", 0, "Queens", 7185281535l, "Small");
		Employee e = new Employee();
		Department d = new Department(0, "IT");
		
		
		employeeList = Filer.loadEmployee("C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\employeeList.data");
		branchList = Filer.loadBranch("C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\branchList.data");
		departmentList = Filer.loadDepartment("C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\departmentList.data");
				
				
		
		//load default values if program not ran yet
//		
//		branchList.add(0,b);
//		employeeList.add(e);
//		departmentList.add(0, d);
		
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		
		do {
			input = Validation.checkInt("Main menu \n" + 
				"1. Manage Employee \n" + 
				"2. Manage Department\n" + 
				"3. Manage Branch \n" + 
				"4. Exit", "Please try again:");
	
		//case for each option calling other runners
		switch(input) {
			case 1:
				manageEmployeeRunner.menu();
			
				break;
			case 2: manageDepartmentRunner.menu();
				break;
			case 3: manageBranchRunner.menu();
			break;
			
			default:
				break;
		}
		
		}while(input!=4);
		
	
		Filer.saveEmployee(employeeList, "C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\employeeList.data");
		Filer.saveBranch(branchList, "C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\branchList.data");
		Filer.saveDepartment(departmentList, "C:\\Users\\Sprinkle\\Dropbox\\SpringTool Workspace Directory\\SprinkleProjects\\Resources\\departmentList.data");
		
	        System.out.println("*****  *   *  *****     ***    *****    *    *****  *****");
	        System.out.println("  *    *   *  *         *   *  *       * *   *   *  *    ");
	        System.out.println("  *    *****  *****     ****   *****  *****  *****  *****");
	        System.out.println("  *    *   *  *         *   *  *      *   *  *  *       *");
	        System.out.println("  *    *   *  *****     ***    *****  *   *  *   *  *****");
	        System.out.println("      _____         __");
            System.out.println("    d8888888o,,,,,o8888o  (@");
            System.out.println("   d888888888888888888888888.*");
            System.out.println("  888888 88888888888 88 8888888o");
            System.out.println("  8888888 888888888 8888 8888`~~");
            System.out.println("   8888888 888888888 88888");
            System.out.println("    888888 8888888888 8888");
            System.out.println("    ## 88888  88888 ## 8888");
            System.out.println("    #### 88888      ### 8888");
            System.out.println("   ###,,, 888,,,    ##,,, 88,,,");
	        System.out.println("\n\n Thanks for using our program!");		
	}

}
