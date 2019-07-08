package com.Sprinkle.EMS;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
	
	public static String valString="";
	public static int  valInt=-1;
	public static double valDbl=-1;
	public static long valLong=-1;
	public static int department=-1;
	public static int typeOfEmployment=-1;
	public static int gender=-1;
	public static int branch=-1;
	
	public Validation() {
	}

	public static String checkString(String instructions, String errMsg) {
		valString="";
		Scanner s = new Scanner(System.in);
		System.out.println(instructions);
		while(valString=="") {	
			try {
				valString=s.nextLine();
			}catch(Exception e){
				System.out.println(errMsg+" Please enter supported characters only!");
				valString="";
				continue;
			}
			finally {}
		}
			return valString;	
	}	
	
	public static int checkInt(String instrutions, String errMsg) {
		valInt=-1;
		Scanner s = new Scanner(System.in);
		System.out.println(instrutions);
		while(valInt==-1) {
			try {
				valInt= s.nextInt();
			}catch(InputMismatchException e) {
				System.out.println(errMsg +" Please enter numbers only!");
				s.nextLine();
				valInt=-1;
			}catch(Exception e) {
				System.out.println("Please format numbers correctly!");
				s.nextLine();
				valInt=-1;
			}finally {}
		}
		return valInt;
	}
		
	public static double checkDbl(String instrutions, String errMsg) {
		valDbl=-1;
		Scanner s = new Scanner(System.in);
		System.out.println(instrutions);
		while(valDbl==-1) {
			try {
				valDbl= s.nextDouble();		
			}catch(InputMismatchException e) {
				System.out.println(errMsg +" Please enter numbers only!");
				s.nextLine();
				valDbl=-1;
			}catch(Exception e) {
				System.out.println("Please format numbers correctly!");
				s.nextLine();
				valDbl=-1;
			}finally {}
		}
		return valDbl;
	}
	public static Long checkPhoneNumber(String instructions) {
		Scanner s = new Scanner(System.in);
		System.out.println(instructions);
		valLong=-1;
		while(valLong==-1) {
			try {
				valLong=s.nextLong();
				s.nextLine();
				if(Long.toString(valLong).length()!=10) {
					System.out.println("Not a valid phone number, number is not the right length. Please enter again");
					valLong=-1;
					continue;
				}
			}catch(InputMismatchException exception) {
				System.out.println("Non-number entered or phone number is too long. Please enter the 10 numbers only");
				s.nextLine();
				valLong=-1;
			}catch(Exception e) {
				System.out.println("Please format numbers correctly!");
				s.nextLine();
				valLong=-1;
			}finally {}
		}
		return valLong;
	}
	public static int checkSSN(String instructions) {
		Scanner s = new Scanner(System.in);
		System.out.println(instructions);
		valInt=-1;
		while(valInt==-1) {
			try {
				valInt= s.nextInt();
				if(Integer.toString(valInt).length()!=9) {
					System.out.println("Not a valid Social Security Number, number is not the right length. Please enter again");
					valInt=-1;
					s.nextLine();
					continue;
				}
			}catch(InputMismatchException e) {
				System.out.println("Social Security Number is either too long or non-number values were submitted, please submit only 9 numbers. ");
				s.nextLine();
				valInt=-1;
			}catch(Exception e) {
				System.out.println("Please format numbers correctly!");
				s.nextLine();
				valInt=-1;
			}finally {}
		}
		return valInt;
	}
	public static int checkDepartment(ArrayList<Department> departmentArrayList, String instructions, String errMsg) {
		department=-1;
		System.out.println(instructions);
		boolean invalid=true;
		int size=0;
		while(invalid) {
			size=departmentArrayList.size();
			department= Validation.checkInt("", "");
			if(department>size||department<=0) {
				System.out.println(errMsg);
			}
			else {
				invalid=false;
			}
			
		}
		return department;
	}
	
	public static int checkTypeOfEmployment(String instructions, String errMsg) {
		typeOfEmployment=-1;
		boolean invalid=true;
		while(invalid) {
			typeOfEmployment= Validation.checkInt("", "");
			if(typeOfEmployment>3||typeOfEmployment<=0) {
				System.out.println(errMsg);
			}
			else {
				invalid=false;
			}
			
		}
		
		return typeOfEmployment;
	}
	public static int checkGender(String instructions, String errMsg) {
		gender=-1;
		boolean invalid=true;
		while(invalid) {
			gender= Validation.checkInt("", "");
			if(gender>4||gender<=0) {
				System.out.println(errMsg);
			}
			else {
				invalid=false;
			}
			
		}
		
		return typeOfEmployment;
	}
	public static int checkBranch(ArrayList<Branch> branchArrayList, String instructions, String errMsg) {
		branch=-1;
		System.out.println(instructions);
		boolean invalid=true;
		int size=0;
		while(invalid) {
			size=branchArrayList.size();
			branch= Validation.checkInt("", "");
			if(branch>size||branch<=0) {
				System.out.println(errMsg);
			}
			else {
				invalid=false;
			}
			
		}
		return branch;
	}
}