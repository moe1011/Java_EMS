package ems;

import java.util.Scanner;

/**
 * @since JRE 14
 * @see Employee
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / Development Class - Abstract class that holds multiple variables and methods for creating a Developer
 */
/**Abstract class that holds multiple variables and methods for creating a Developer*/
public abstract class Development implements Employee {
	
	//Instance Variables
	protected int employeeID;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected int supervisorID;
	protected double yearlySal = -1;
	protected String platform;
	protected String area;
	
	/**Constructor for the Development Class*/
	Development(){
		
	}
	/**To create output of employee details*/
	public String toString() {
		
		return "";
	}
	/**To add a new Developer*/
	public void addEmployee(Scanner input) {
		
		
	}

}
