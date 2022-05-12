package ems;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @since JRE 14
 * @see Management
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / Manager Class - Class to add a new Manager
 */
/**Class to add a new Manager*/
public class Manager extends Management {
	
	//Instance Variables
	protected String rank;
	/**Constructor for the Manager Class*/
	Manager(){
		
	}
	/**To create output of employee details*/
	public String toString() {
		System.out.printf("Name: %1s | Employee ID: %1s | Email: %1s  | Yearly Salary: %.2f | Designation: %5s | Rank: %1s",(firstName+" "+lastName),employeeID,email,yearlySal,"Manager",rank);
		System.out.println("");
		return "";
	}
	
	/**To add a new Manager*/
	public void addEmployee(Scanner input) {
		
		System.out.print("Enter the email of the manager: ");
		email = input.next();
		
		while(yearlySal < 0) {
			try {
				System.out.print("Enter salary(yearly) of the manager: ");
				yearlySal = input.nextDouble();
				if(yearlySal < 0) {
					System.out.println("");
					System.err.println("Please enter a positive value");
				}
			}catch(InputMismatchException e) {
				System.out.println("");
				System.err.println("Please enter a numerical value");
				input.next();
			}
			
		}
		
		System.out.print("Enter the team name of the manager: ");
		teamName = input.next();
		System.out.print("Enter the rank of the manager: ");
		rank = input.next();
	}
	
	

}
