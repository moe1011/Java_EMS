package ems;

import java.util.Scanner;

/**
 * @since JRE 14
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / Employee Class - Interface class to make sure methods exist in other classes
 */

/**Interface class to make sure methods exist in other classes*/
interface Employee {
	
	/**To create output of employee details*/
	public String toString();
	
	/**To add a new Manager or Developer*/
	public void addEmployee(Scanner input);

}
