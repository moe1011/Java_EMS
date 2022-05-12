package ems;

import java.util.Scanner;

/**
 * @since JRE 14
 * @see Employee
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / Management Class - Abstract class that holds multiple variables and methods for creating a Manager
 */
/**Abstract class that holds multiple variables for creating a Manager*/
public abstract class Management implements Employee {
	
	//Instance Variables
	protected int employeeID;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected double yearlySal = -1;
	protected String teamName;

	/**Constructor for the Management Class*/
	Management(){
		
	}
	/**To create output of employee details*/
	public String toString() {
		
		return "";
	}
	/**To add a new Manager*/
	public void addEmployee(Scanner input) {
		
	}
}
