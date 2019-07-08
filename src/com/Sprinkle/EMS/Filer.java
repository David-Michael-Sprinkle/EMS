package com.Sprinkle.EMS;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.OutputStream;
	import java.util.ArrayList;

	public class Filer {
		
		public static void saveEmployee(ArrayList<Employee> AL,String filePath){
			try {
			File saveFile= new File(filePath);
			FileOutputStream fOS= new FileOutputStream(saveFile);
			ObjectOutputStream os= new ObjectOutputStream(fOS);
			os.writeObject(AL);
			os.close();
			}catch(FileNotFoundException f) {
				System.out.println("File not found! please seek help from the awesome developers in Team2");
			}catch(IOException i) {
				System.out.println("IOException encountered");
				System.out.println(i.getMessage());
				i.getStackTrace();
				i.printStackTrace();
			}catch(Exception e) {
				System.out.println("Unknown Exception");
			}
		}
		public static void saveBranch(ArrayList<Branch> AL,String filePath){
			try {
			File saveFile= new File(filePath);
			FileOutputStream fOS= new FileOutputStream(saveFile);
			ObjectOutputStream os= new ObjectOutputStream(fOS);
			os.writeObject(AL);
			os.close();
			}catch(FileNotFoundException f) {
				System.out.println("File not found! please seek help from the awesome developers in Team2");
			}catch(IOException i) {
				System.out.println("IOException encountered");
			}catch(Exception e) {
				System.out.println("Unknown Exception");
			}
		}
		public static void saveDepartment(ArrayList<Department> AL,String filePath){
			try {
			File saveFile= new File(filePath);
			FileOutputStream fOS= new FileOutputStream(saveFile);
			ObjectOutputStream os= new ObjectOutputStream(fOS);
			os.writeObject(AL);
			os.close();
			}catch(FileNotFoundException f) {
				System.out.println("File not found! please seek help from the awesome developers in Team2");
			}catch(IOException i) {
				System.out.println("IOException encountered");
			}catch(Exception e) {
				System.out.println("Unknown Exception");
			}
		}
		public static ArrayList<Employee> loadEmployee(String filePath) {
			ArrayList<Employee> AL=null;
			File loadFile= new File(filePath);
			try {
				FileInputStream fIS= new FileInputStream(loadFile);
				ObjectInputStream oIS= new ObjectInputStream(fIS);
				AL= (ArrayList<Employee>) oIS.readObject();
				oIS.close();
				
			} catch (FileNotFoundException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			} catch(IOException I) {
				
			}catch(Exception e) {
				
			}
			return AL;
			
		}
		public static ArrayList<Branch> loadBranch(String filePath) {
			ArrayList<Branch> AL=null;
			File loadFile= new File(filePath);
			try {
				FileInputStream fIS= new FileInputStream(loadFile);
				ObjectInputStream oIS= new ObjectInputStream(fIS);
				AL= (ArrayList<Branch>)oIS.readObject();
				oIS.close();
			} catch (FileNotFoundException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			} catch(IOException I) {
				
			}catch(Exception e) {
				
			}
			return AL;
			
		}
		public static ArrayList<Department> loadDepartment(String filePath) {
			ArrayList<Department> AL=null;
			File loadFile= new File(filePath);
			try {
				FileInputStream fIS= new FileInputStream(loadFile);
				ObjectInputStream oIS= new ObjectInputStream(fIS);
				AL= (ArrayList<Department>)oIS.readObject();
				oIS.close();
			} catch (FileNotFoundException f) {
				// TODO Auto-generated catch block
				f.printStackTrace();
			} catch(IOException I) {
				
			}catch(Exception e) {
				
			}
			return AL;
			
		}
	}


