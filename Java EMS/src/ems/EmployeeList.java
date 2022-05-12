package ems;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * @since JRE 14
 * @author Mohammed Abdulla
 * @version 1.0
 * Professor: Daniel Cormier
 * Date: April 4, 2021
 * Description: Lab 9 / EmployeeList Class - A class which holds multiple methods that correspond to the menu input
 */
/** A class which holds multiple methods that correspond to the menu input */
public class EmployeeList {

	// Instance Variables
	// ArrayLists objects
	protected ArrayList<Management> managementList = new ArrayList<Management>();
	protected ArrayList<Development> devList = new ArrayList<Development>();
	boolean foundID = false;
	int empID;

	protected String empType;

	/** Constructor for the EmployeeList Class */
	EmployeeList() {

	}

	/**
	 * Adds a new employee to the EMS
	 * 
	 * @param input - To take in input value from the user
	 * @throws InterruptedException - Pauses code for a certain amount of time
	 */
	public void addEmployee(Scanner input) throws InterruptedException {
		String fname;
		String lname;
		
		empID = -1;
		System.out.println("");
		System.out.println("Enter details of employee # " + (managementList.size() + devList.size() + 1)); // employee number need to be added
		System.out.println("=================================");
		System.out.println("Please select the type of employee you wish to add.");
		System.out.print("Type (without quotations) 'm' for Manager or 'd' for IT Developer or 'a' for IT Analyst : ");
		empType = input.next().toLowerCase();

		switch (empType) {
		// Manager
		case "m":

			Management manager = new Manager();
			managementList.add(manager);

			System.out.print("Enter first name of the manager: ");
			managementList.get(managementList.size() - 1).firstName = input.next();
			fname = managementList.get(managementList.size() - 1).firstName.substring(0, 1).toUpperCase()
					+ managementList.get(managementList.size() - 1).firstName.substring(1).toLowerCase();
			managementList.get(managementList.size() - 1).firstName = fname;

			System.out.print("Enter last name of the manager: ");
			managementList.get(managementList.size() - 1).lastName = input.next();
			lname = managementList.get(managementList.size() - 1).lastName.substring(0, 1).toUpperCase()
					+ managementList.get(managementList.size() - 1).lastName.substring(1).toLowerCase();
			managementList.get(managementList.size() - 1).lastName = lname;

			while (empID < 1 || empID > 9999) {
				try {
					System.out.print("Enter the ID of the manager (1 - 4 digits): ");
					empID = input.nextInt();
					if (empID < 1 || empID > 9999) {
						System.out.println("");
						System.err.println("1 - 4 digtis only for a Manager ID");
					}

					// Checking for duplicate employee ID's
					else if (managementList.size() != 0 || devList.size() != 0) {
						for (int i = 0; i < managementList.size(); i++) {
							if (empID == managementList.get(i).employeeID) {
								System.err.println("An employee with that ID already exists");
								System.out.println("");
								empID = -1;
								Thread.sleep(1500);
							} else if (devList.size() != 0) {
								if (empID == devList.get(i).employeeID) {
									System.err.println("An employee with that ID already exists");
									System.out.println("");
									empID = -1;
									Thread.sleep(1500);
								}

							}
						}
					}

				} catch (InputMismatchException e) {
					System.out.println("");
					System.err.println("Please enter a valid numerical value (1 - 4 digits)");
					input.next();
				}

			}

			managementList.get(managementList.size() - 1).employeeID = empID;
			managementList.get(managementList.size() - 1).addEmployee(input);

			break;
		// IT DEV
		case "d":
			if (managementList.size() == 0) {
				System.err.println("There are no Managers for an employee to be created");
				return;
			}

			Development itDev = new ITDeveloper();
			devList.add(itDev);

			System.out.print("Enter first name of the employee: ");
			devList.get(devList.size() - 1).firstName = input.next();
			fname = devList.get(devList.size() - 1).firstName.substring(0, 1).toUpperCase()
					+ devList.get(devList.size() - 1).firstName.substring(1).toLowerCase();
			devList.get(devList.size() - 1).firstName = fname;

			System.out.print("Enter last name of the employee: ");
			devList.get(devList.size() - 1).lastName = input.next();
			lname = devList.get(devList.size() - 1).lastName.substring(0, 1).toUpperCase()
					+ devList.get(devList.size() - 1).lastName.substring(1).toLowerCase();
			devList.get(devList.size() - 1).lastName = lname;

			while (empID < 1 || empID > 9999) {
				try {
					System.out.print("Enter the ID of the employee (1 - 4 digits): ");
					empID = input.nextInt();
					if (empID < 1 || empID > 9999) {
						System.out.println("");
						System.err.println("1 - 4 digtis only for an employee ID");
					} else if (managementList.size() != 0 || devList.size() != 0) {
						for (int i = 0; i < devList.size(); i++) {
							if (empID == devList.get(i).employeeID) {
								System.err.println("An employee with that ID already exists");
								System.out.println("");
								empID = -1;
								Thread.sleep(1500);
							}
						}
					}

				} catch (InputMismatchException e) {
					System.out.println("");
					System.err.println("Please enter a valid numerical value (1 - 4 digits)");
					input.next();
				}

			}

			devList.get(devList.size() - 1).employeeID = empID;
			devList.get(devList.size() - 1).addEmployee(input);

			// check if a supervisor ID matches a managers ID
			while ((devList.get(devList.size() - 1).supervisorID < 1
					|| devList.get(devList.size() - 1).supervisorID > 9999) || foundID == false) {
				try {
					System.out.print("Enter the Supervisor's ID of the employee: ");
					devList.get(devList.size() - 1).supervisorID = input.nextInt();
					for (int i = 0; i < managementList.size(); i++) {
						if (devList.get(devList.size() - 1).supervisorID == managementList.get(i).employeeID) {
							foundID = true;
						}

					}
					if (foundID == false) {
						System.out.println("");
						System.err.println("There are no supervisors with the ID: "
								+ devList.get(devList.size() - 1).supervisorID);
					}

				} catch (InputMismatchException e) {
					System.out.println("");
					System.err.println("Please enter a valid numerical value (1 - 4 digits)");
					input.next();
				}

			}

			System.out.print("Enter the programming platform of the IT Developer: ");
			devList.get(devList.size() - 1).platform = input.next();

			break;
		// IT ANA
		case "a":
			if (managementList.size() == 0) {
				System.err.println("There are no Managers for an employee to be created");
				return;
			}

			Development itAna = new ITAnalyst();
			devList.add(itAna);

			System.out.print("Enter first name of the employee: ");
			devList.get(devList.size() - 1).firstName = input.next();
			fname = devList.get(devList.size() - 1).firstName.substring(0, 1).toUpperCase()
					+ devList.get(devList.size() - 1).firstName.substring(1).toLowerCase();
			devList.get(devList.size() - 1).firstName = fname;

			System.out.print("Enter last name of the employee: ");
			devList.get(devList.size() - 1).lastName = input.next();
			lname = devList.get(devList.size() - 1).lastName.substring(0, 1).toUpperCase()
					+ devList.get(devList.size() - 1).lastName.substring(1).toLowerCase();
			devList.get(devList.size() - 1).lastName = lname;

			while (empID < 1 || empID > 9999) {
				try {
					System.out.print("Enter the ID of the employee (1 - 4 digits): ");
					empID = input.nextInt();
					if (empID < 1 || empID > 9999) {
						System.out.println("");
						System.err.println("1 - 4 digtis only for an employee ID");
					} else if (managementList.size() != 0 || devList.size() != 0) {
						for (int i = 0; i < devList.size(); i++) {
							if (empID == devList.get(i).employeeID) {
								System.err.println("An employee with that ID already exists");
								System.out.println("");
								empID = -1;
								Thread.sleep(1500);
							}
						}
					}

				} catch (InputMismatchException e) {
					System.out.println("");
					System.err.println("Please enter a valid numerical value (1 - 4 digits)");
					input.next();
				}

			}

			devList.get(devList.size() - 1).employeeID = empID;
			devList.get(devList.size() - 1).addEmployee(input);

			while ((devList.get(devList.size() - 1).supervisorID < 1
					|| devList.get(devList.size() - 1).supervisorID > 9999) || foundID == false) {
				try {
					System.out.print("Enter the Supervisor's ID of the employee: ");
					devList.get(devList.size() - 1).supervisorID = input.nextInt();
					for (int i = 0; i < managementList.size(); i++) {
						if (devList.get(devList.size() - 1).supervisorID == managementList.get(i).employeeID) {
							foundID = true;
						}

					}
					if (foundID == false) {
						System.out.println("");
						System.err.println("There are no supervisors with the ID: "
								+ devList.get(devList.size() - 1).supervisorID);
					}
				} catch (InputMismatchException e) {
					System.out.println("");
					System.err.println("Please enter a valid numerical value (1 - 4 digits)");
					input.next();
				}

			}
			System.out.print("Enter the area of analysis of the IT Analyst: ");
			devList.get(devList.size() - 1).area = input.next();

			break;
		default:
			System.out.println(empType + " is an invalid input");
			Thread.sleep(1500);

		}

	}

	/** Prints details about all employees */
	public void printEmployeeDetails() {

		if (managementList.size() == 0 && devList.size() == 0) {
			System.err.println("There are no employees in the system for details to be printed out");
			return;
		}

		System.out.println("");
		System.out.println("Employee Management System");
		System.out.println("******************");
		System.out.println("Number of employees : " + (managementList.size() + devList.size()));
		System.out.println("");
		System.out.println("List of Management Employees");
		System.out.println("");

		for (int i = 0; i < managementList.size(); i++) {
			managementList.get(i).toString();
		}

		System.out.println("");
		System.out.println("List of Development Employees");
		System.out.println("");

		for (int i = 0; i < devList.size(); i++) {
			devList.get(i).toString();
		}

	}

	/**
	 * Updates the email address of an employee
	 * 
	 * @param input - To take in input value from the user
	 */
	public void updateEmail(Scanner input) {
		int accNum = -1;
		String email;
		boolean foundID = false;

		if (managementList.size() == 0 && devList.size() == 0) {
			System.err.println("There are no employees in the system for an email to be updated");
			return;
		}

		try {
			System.out.print("Enter the ID of the employee whose email needs to be updated: ");
			accNum = input.nextInt();
			System.out.println("");
		} catch (InputMismatchException e) {
			System.err.println("Please enter a numerical ID next time (1 - 4 digits)");
			input.next();
			return;
		}

		for (int i = 0; i < managementList.size(); i++) {
			if (accNum == managementList.get(i).employeeID) {
				System.out.print("Enter the new Email address of the employee: ");
				email = input.next();
				System.out.println("The new email address of " + managementList.get(i).firstName + " "
						+ managementList.get(i).lastName + " is: " + email);
				foundID = true;
				managementList.get(i).email = email;
				break;
			}
		}
		for (int i = 0; i < devList.size(); i++) {
			if (accNum == devList.get(i).employeeID) {
				System.out.print("Enter the new Email address of the employee: ");
				email = input.next();
				System.out.println("The new email address of " + devList.get(i).firstName + " "
						+ devList.get(i).lastName + " is: " + email);
				foundID = true;
				devList.get(i).email = email;
				break;
			}
		}

		if (foundID == false) {
			System.err.println("There is no employee with the employee ID: " + accNum);
		}
	}

	/** Runs the monthly Payroll for all employees */
	public void monthlyPayroll() {
		double monthlySal;

		// making a value two decimal places
		DecimalFormat df2 = new DecimalFormat("#.##");
		if (managementList.size() == 0 && devList.size() == 0) {
			System.err.println("There are no employees for a monthly payroll to be completed");
		}

		for (int i = 0; i < managementList.size(); i++) {
			monthlySal = managementList.get(i).yearlySal / 12;
			monthlySal -= monthlySal * 0.20;

			System.out.println("Depost $" + df2.format(monthlySal) + " into " + managementList.get(i).firstName + " "
					+ managementList.get(i).lastName + "'s bank account");
		}

		for (int i = 0; i < devList.size(); i++) {
			monthlySal = devList.get(i).yearlySal / 12;
			monthlySal -= monthlySal * 0.20;
			System.out.println("Deposited $" + df2.format(monthlySal) + " into " + devList.get(i).firstName + " "
					+ devList.get(i).lastName + "'s bank account");
		}

	}

	/**
	 * Displays the team of a specified Manager
	 * 
	 * @param input - To take in input value from the user
	 */
	public void displayTeamEmployee(Scanner input) {
		// make sure manager is needed for accounts, fix incorrect inputs
		int accNum;
		boolean foundID = false;

		if (managementList.size() == 0) {
			System.err.println("There are no employees in the system to be displayed");
			return;
		}

		try {
			System.out.print("Enter the employee ID of the Manager to display the members of his team: ");
			accNum = input.nextInt();
			System.out.println("");
		} catch (InputMismatchException e) {
			System.err.println("Please enter a numerical ID next time (1 - 4 digits)");
			input.next();
			return;
		}

		for (int i = 0; i < managementList.size(); i++) {
			if (accNum == managementList.get(i).employeeID) {
				System.out.println(
						"Manager's Name: " + managementList.get(i).firstName + " " + managementList.get(i).lastName);
				System.out.println("Detail info for the members of " + managementList.get(i).teamName + " team:");
				foundID = true;
				break;
			}
		}

		if (foundID == false) {
			System.err.println("There is no Manager with the ID: " + accNum);
			return;
		} else if (foundID == true) {
			foundID = false;

		}

		for (int i = 0; i < devList.size(); i++) {
			if (accNum == devList.get(i).supervisorID) {
				devList.get(i).toString();
				foundID = true;
			}
		}

		if (foundID == false) {
			System.out.println("There are no employees for this team");
		}

	}

	public void searchEmployee(Scanner input) throws InterruptedException {
		if (managementList.size() == 0 && devList.size() == 0) {
			System.err.println("There are no employees in the system to be searched");
			return;
		}

		String option = "z";
		String name;
//		System.out.println(managementList.size());
//		System.out.println(devList.size());
		while (!(option.equals("f")) || !(option.equals("l") || !(option.equals("e")))) {
			System.out.println("Please enter search criteria");
			System.out.print(
					"Type (without quotations) 'f' for searching by first name or 'l' for searching by last name and 'e' to exit the search: ");
			option = input.next();
			option = option.toLowerCase();

			if (option.equals("f")) {
				System.out.println("Enter the first name of the employee you are looking for");
				name = input.next();
				name = name.toLowerCase();
				for (int i = 0; i < managementList.size(); i++) {
					if (name.equals(managementList.get(i).firstName.toLowerCase())) {
						managementList.get(i).toString();
						return;
					} else if (devList.size() != 0) {
						if (name.equals(devList.get(i).firstName.toLowerCase())) {
							devList.get(i).toString();
							return;
						}

					} else {
						System.out.println("There is no employee with that first name");
						System.out.println("");
						Thread.sleep(1500);
						return;
					}
				}

			} else if (option.equals("l")) {
				System.out.println("Enter the last name of the employee you are looking for");
				name = input.next();
				name = name.toLowerCase();
				for (int i = 0; i < managementList.size(); i++) {
					if (name.equals(managementList.get(i).lastName.toLowerCase())) {
						managementList.get(i).toString();
						return;
					} else if (devList.size() != 0) {
						if (name.equals(devList.get(i).lastName.toLowerCase())) {
							devList.get(i).toString();
							return;
						}

					} else {
						System.out.println("There is no employee with that last name");
						System.out.println("");
						Thread.sleep(1500);
						return;
					}
				}

			} else if (option.equals("e")) {
				return;
			} else {
				System.err.println("Please enter a valid input");
				System.out.println("");
				Thread.sleep(1500);
			}
		}

	}

	/**
	 * Removes an employee from the system given their ID
	 * 
	 * @param input - Scanner used to take in input
	 * */
	public void removeEmployee(Scanner input) {
		int empId = 0;
		try {
			System.out.print("Enter ID of the employee you wish to remove: ");
			empId = input.nextInt();
		} catch (Exception e) {
			System.err.println("That is an invalid employee ID.");
			return;
		}

		for (int i = 0; i < devList.size(); i++) {
			if(empId == devList.get(i).employeeID) {
				System.out.println(devList.get(i).firstName + " " + devList.get(i).lastName + " with ID " + devList.get(i).employeeID + " has been removed.");
				devList.remove(i);
				return;
			}
		}
		System.out.println("An employee with that ID does not exist");
	}

//	public void promoteEmployee() {
//
//	}

}// End of class
