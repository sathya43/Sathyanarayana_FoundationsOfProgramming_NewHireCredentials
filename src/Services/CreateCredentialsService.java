package Services;

import java.util.Random;

import Models.Employee;
import Utilities.Utilities;



public class CreateCredentialsService {
	
	public CreateCredentialsService() {}
	
	Random random = new Random();
	
	Utilities utilities = new Utilities();
	
	
	
    /*
     * This is a method used to generate a password of desired length
     * The password is generated as per the password policy mentioned
     * The generated password is stored for corresponding employee
     */
	public void generatePassword(Employee employee, int passwordLength) {
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters= "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String specialCharacters = "@#$%&!";
		
		String password = "";
		password +=  utilities.generateRandomString(upperCaseLetters, passwordLength / 2);
		password += utilities.generateRandomString(lowerCaseLetters, passwordLength / 4);
		password += utilities.generateRandomString(specialCharacters, 1);
		password += utilities.generateRandomString(numbers, (passwordLength / 4) - 1);
		
		employee.setPassword(password);
	}
	
	
	
	/*
	 * This is a method used to generate the email address for newHires
	 * We assume that the fields firstName, lastName, Company and Department are mandatory
	 *
	 */
	public void generateEmailAddress(Employee employee) throws NullPointerException {
		String email = "";
		String firstName  = employee.getFirstName();
		String lastName = employee.getLastName();
		String company = employee.getCompany();
		String department = employee.getDepartment();
		
	try {
		company =  company.toLowerCase();
		company = utilities.trimSpaces(company);
		
		
		department = department.toLowerCase();
		department = utilities.trimSpaces(department);
		
		firstName = firstName.toLowerCase();
		lastName = lastName.toLowerCase();
	}catch(NullPointerException ex) {
		System.out.println("Exception thrown because Company/departement/firstName/lastName is ----> " + ex.getMessage());
		ex.printStackTrace(new java.io.PrintStream(System.out));
	}finally{
		
	email =  email + firstName + lastName + "@";
    email = email + department + "." + company + ".com";	  

    employee.setEmail(email);
	}
}
	
	
	
	/*
	 * This method is used to display the credentials of the Employees.
	 * The email and password generated for the employee are displayed
	 */
	public void showCredentials(Employee employee) {
		System.out.println("\nDear " + employee.getFirstName() + " your generated crdentials are as follows");
		System.out.println("Email      --->  " + employee.getEmail());
		System.out.println("Password   --->  " + employee.getPassword());
		
	}
}
