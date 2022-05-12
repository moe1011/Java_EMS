package ems;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @since JRE 14
 * @see Development
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / ITDeveloper Class - Class to add a new ITDeveloper
 */
/**Class to add a new ITDeveloper*/
public class ITDeveloper extends Development {
	
	/**Constructor for the ITDeveloper Class*/
	ITDeveloper(){
		
	}
	/**To create output of employee details*/
	public String toString() {
		System.out.printf("Name: %1s | Employee ID: %1s | Email: %1s | Supervisor ID: %1s | Yearly Salary: %.2f | Designation: %1s | Programming Platform: %1s",(firstName+" "+lastName),employeeID,email,supervisorID,yearlySal,"IT Developer",platform);
		System.out.println("");
		return "";
	}
	/**To add a new Developer*/
	public void addEmployee(Scanner input) {
		
		System.out.print("Enter the email of the employee: ");
		email = input.next();
		
		while(yearlySal < 0) {
			try {
				System.out.print("Enter salary(yearly) of the employee: ");
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
		
		
	}

}
