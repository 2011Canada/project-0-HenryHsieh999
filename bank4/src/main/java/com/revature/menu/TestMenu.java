package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.CustomerServicesImplementation;
import com.revature.services.EmployeeServicesImplementation;

public class TestMenu {
	static boolean employeeFlag;
	static String username = "";
	static String password = "";
	static String yn = "";
	static double money = 0;
	static UserPostgresDAO uPDAO;
	static User u;
	static int id = -10;
	static int state = 0;
	static int menuState = 0;
	UserDAO ud = new UserPostgresDAO();
	CustomerServicesImplementation csi;
	EmployeeServicesImplementation esi = new EmployeeServicesImplementation(ud);
	Scanner userIn;
	List<User> uList;
	public void display() throws UserNotFoundException {
		
		System.out.println("------------------------------");
		System.out.println("     WELCOME TO HARD BANK     ");
		System.out.println(" WHERE WE PLAY WITH YOUR MONEY");
		System.out.println("------------------------------");
		System.out.println("|                          |");
		System.out.println("| Login Options:           |");
		System.out.println("|        1. Employee       |");
		System.out.println("|        2. Customer       |");
		System.out.println("|        3. Exit           |");
		state = Keyin.inInt(" Select option: ");


		switch (state) {
		case 1:
			System.out.println("Option 1 selected");
			System.out.println("Please enter your username and password: \n");
			System.out.println("Username:\n");
			username = Keyin.inString();
			System.out.println("Password:\n");
			password = Keyin.inString();
			try {
				esi.login(username, password);
			} catch(UserNotFoundException e) {
				e.printStackTrace();
				throw new UserNotFoundException();
			}
			break;
		case 2:
			System.out.println("Option 2 selected");
			System.out.println("Please enter your username and password: \n");
			System.out.println("Username:\n");
			username = Keyin.inString();
			System.out.println("Password:\n");
			password = Keyin.inString();
			try {
				csi.login(username, password);
			} catch(UserNotFoundException e) {
				e.printStackTrace();
				throw new UserNotFoundException();
			} 
			break;
		case 3:
			System.out.println("Exited the program");
			System.exit(0);
			break;
		case 1000:
			System.out.println("Option 1 selected");
			System.out.println("Please enter the Bank Account id you want to Reject.\n");
			System.out.println("Bank Account id");
			id = Integer.parseInt(Keyin.inString());
			esi.approveCustomerBankAccountStatus(id);

			break;
		case 1001:
			System.out.println("Option 3 selected");
			System.out.println("Now displaying all customer accounts.\n");

			esi.findAllCustomer();

			break;
		case 1002:
			System.out.println("Option 4 selected");
			System.out.println("Please enter the User Account id you want to Find.\n");
			System.out.println("User Account ID:\n");
			id = Integer.parseInt(Keyin.inString());
			esi.findAccount(id);
			break;
		case 1003:
			System.out.println("You are now logged out");
			break;
		case 1004:
			System.out.println("|                             |");
			System.out.println("| Employee Options:           |");
			System.out.println("|  1. RejectBankAccount       |");
			System.out.println("|  2. AcceptBankAccount       |");
			System.out.println("|  3. ViewAllCustomerAccounts |");
			System.out.println("|  4. findUserByUserId        |");
			System.out.println("|  5. View Log                |");
			System.out.println("|100. Back to Employee Options|");
			System.out.println("|  6. Logout                  |");
		default:
			System.out.println("Invalid selection");
			break;

		}

	}

}

class Keyin {

	//*******************************
	//   support methods
	//*******************************
	//Method to display the user's prompt string
	public static void printPrompt(String prompt) {
		System.out.print(prompt + " ");
		System.out.flush();
	}

	//Method to make sure no data is available in the
	//input stream
	public static void inputFlush() {
		int dummy;
		int bAvail;

		try {
			while ((System.in.available()) != 0)
				dummy = System.in.read();
		} catch (java.io.IOException e) {
			System.out.println("Input error");
		}
	}
	public static String inString() {
		int aChar;
		String s = "";
		boolean finished = false;

		while (!finished) {
			try {
				aChar = System.in.read();
				if (aChar < 0 || (char) aChar == '\n')
					finished = true;
				else if ((char) aChar != '\r')
					s = s + (char) aChar; // Enter into string
			}

			catch (java.io.IOException e) {
				System.out.println("Input error");
				finished = true;
			}
		}
		return s;
	}

	public static int inInt(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Integer.valueOf(inString().trim()).intValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid input. Not an integer");
			}
		}
	}

}

