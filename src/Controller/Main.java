package Controller;

import java.util.Scanner;

import Models.Employee;
import Services.CreateCredentialsService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * Hard coding the employee/new Hire details to generate the credentials
		 */
		Employee newHire = new Employee("Sathya","Narayana");
		
		newHire.setCompany("Great Learning");
		
		/*
		 * We can have the employee details fed to the program dynamically with below code
		 * We create the employee object with the details entered
		 * 
		 * Comment the above two lines and uncomment below lines to feed information
		 * */
         // String firstName, lastName, company;
         // System.out.println("Enter the details of new hire for generating credentials");
         // System.out.println("Enter the first name of new hire");
         // firstName = sc.nextLine();
         // System.out.println("Enter the last name of new hire");
         // lastName = sc.nextLine();
         // System.out.println("Enter the company name");
         // company = sc.nextLine();
         //		  
         // Employee newHire = new Employee(firstName, lastName);
         // newHire.setCompany(company);
	
		
		
		CreateCredentialsService creatCredentials = new CreateCredentialsService();
	
		
		
		System.out.println("Please enter the department from the following\n 1. Technical "
				+ "\n 2. Admin \n 3. Human Resources \n 4. Legal"
				);
		int choice = sc.nextInt();
		String department;
		
		switch(choice) {
		case 1:
		 department = "Technical";
			newHire.setDepartment(department);
			break;
		case 2: 
			department = "Admin";
			newHire.setDepartment(department);
			break;
		case 3: 
			department = "Human Resource";
			newHire.setDepartment(department);
			break;
		case 4: 
			department = "Legal";
			newHire.setDepartment(department);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		creatCredentials.generateEmailAddress(newHire);
		creatCredentials.generatePassword(newHire,12);
		
		
		creatCredentials.showCredentials(newHire);
		
		sc.close();
	}
	
	
	
	
}
