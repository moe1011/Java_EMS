package ems;

import java.util.Scanner;

/**
 * @since JRE 14
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / Lab9 Class - Main class to execute commands
 */
/** Main class to execute commands */
public class Lab9 {

	/**
	 * Main class to execute commands
	 * 
	 * @param args - Main class
	 * @throws InterruptedException - Pauses code for a certain amount of time
	 */
	public static void main(String[] args) throws InterruptedException {
		// Variables
		String option = "z";

		// Scanner for getting input
		Scanner input = new Scanner(System.in);
		// EmployeeList object
		EmployeeList empList = new EmployeeList();

		// Loop to keep the user in the program until they choose the option exit
		while (true) {
			System.out.println("======= Welcome to the Employee Management System =======");
			System.out.println("a: Add a new employee (Management/Development)");
			System.out.println("u: Update email address of an employee");
			System.out.println("d: Display the employees supervised by a team manager");
			System.out.println("p: Print the info of all employees");
			System.out.println("m: Run monthly payroll");
			System.out.println("s: Search for an employee");
//			System.out.println("e: Promote an employee");
			System.out.println("r: Remove an employee");
			System.out.println("q: Quit");
			System.out.println();
			System.out.print("Enter your option: ");
			option = input.next().toLowerCase();

			switch (option) {
			case "a":
				empList.addEmployee(input);
				System.out.println("");

				break;
			case "u":
				empList.updateEmail(input);
				System.out.println("");

				break;
			case "d":
				empList.displayTeamEmployee(input);
				System.out.println("");

				break;
			case "p":
				empList.printEmployeeDetails();
				System.out.println("");

				break;
			case "m":
				empList.monthlyPayroll();
				System.out.println("");

				break;
			case "s":
				empList.searchEmployee(input);
				System.out.println("");

				break;
//			case "e":
//				empList.promoteEmployee();
//				System.out.println("");
//
//				break;
			case "r":
				empList.removeEmployee(input);
				System.out.println("");

				break;
			case "q":
				System.out.println("Program Ended");
				System.exit(0);

				break;
			default:
				System.out.println(option + " is an invalid input");
				Thread.sleep(1500);
				System.out.println("");

			}

		}

	}
}
