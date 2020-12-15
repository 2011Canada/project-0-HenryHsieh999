package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.CustomerServicesImplementation;
import com.revature.services.EmployeeServicesImplementation;

public class TestMenu1 {	static boolean employeeFlag;
	static String username = "";
	static String password = "";
	static String yn = "";
	static double money = 0;
	static double totalBalance = 0;
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
	TestMenu1 tm;
	static int selection = 0;
	
	public void display() throws UserNotFoundException {
		System.out.println("------------------------------");
		System.out.println("     WELCOME TO HARD BANK     ");
		System.out.println(" WHERE WE PLAY WITH YOUR MONEY");
		System.out.println("------------------------------");

		while(true) {
			System.out.println("------------------------------");
			System.out.println("|                            |");
			System.out.println("| Login Options:             |");
			System.out.println("|        1. Employee         |");
			System.out.println("|        2. Customer         |");
			System.out.println("|        3. Exit             |");
			System.out.println("------------------------------");
			state = inInt("login options:"); 
			switch(state){
				case 1:
					employeeLogin();
					break;
				case 2:
					customerLogin();
					break;
				case 3:
					System.out.println("You have exited the program!");
					System.exit(0);
					break;
				default:
					System.out.println("Please make a valid selection");
					break;
				}
		}
	}
	public void employeeMenuOption() throws UserNotFoundException {
		while(true) {
			System.out.println("-------------------------------");
			System.out.println("|                             |");
			System.out.println("| Employee Options:           |");
			System.out.println("|  1. RejectBankAccount       |");
			System.out.println("|  2. AcceptBankAccount       |");
			System.out.println("|  3. ViewAllCustomerAccounts |");
			System.out.println("|  4. findUserByUserId        |");
			System.out.println("|  5. View Log                |");
			System.out.println("|  6. Logout                  |");
			System.out.println("-------------------------------");
			state = inInt("Employee options:"); 
			switch(state){
				case 1:
					rejectBankAccount();
					break;
				case 2:
					AcceptBankAccount();
					break;
				case 3:
					viewAllCustomerAccounts();
					break;
				case 4:
					findUserByUserId();
					break;
				case 5:
					viewLog();
					break;
				case 6:
					System.out.println("You have logged out!");
					display();
					break;
				default:
					System.out.println("Please make a valid selection");
					break;
				}
		}
	}
	public void customerMenuOption() throws UserNotFoundException {
		while(true) {
			System.out.println("-------------------------------------------");
			System.out.println("|                                         |");
			System.out.println("| Customer Options:                       |");
			System.out.println("|  1. Withdraw                            |");
			System.out.println("|  2. Deposit                             |");
			System.out.println("|  3. View Account Balance                |");
			System.out.println("|  4. Accept Money Transfer               |");
			System.out.println("|  5. Transfer Money to another account   |");			
			System.out.println("|  6. Logout                              |");
			System.out.println("-------------------------------------------");
			state = inInt("Customer options:");  
			switch(state){
				case 1:
					withdraw();
					break;
				case 2:
					deposit();
					break;
				case 3:
					viewAccountBalance();
					break;
				case 4:
					acceptMoneyTransfer();
					break;
				case 5:
					transferMoneytoAnotherAccount();
					break;
				case 6:
					System.out.println("You have logged out!\n");
					display();
					break;
				default:
					System.out.println("Please make a valid selection\n");
					break;
				}
		}
	}
	
	private void withdraw() throws UserNotFoundException {
		System.out.println("Option 1 selected\n");
		System.out.println("Please enter the amount of money you would like to withdraw.\n");
		money = inDouble(inString());
		if(money <= 0.0) {
			System.out.println("Please enter a valid amount!\n");
		}else if(money > 0.0) {
			totalBalance = u.getBalance();
			User user = new User(totalBalance - money, Integer.parseInt(u.toString()));
			csi.withdraw(user);			
		}else {
			System.out.println("Please enter a valid input!\n");
			customerMenuOption();
		}
	}


	private void deposit() throws UserNotFoundException {
		System.out.println("Option 2 selected\n");
		System.out.println("Please enter the amount of money you would like to deposit.\n");
		money = inDouble(inString());
		if(money <= 0.0) {
			System.out.println("Please enter a valid amount!\n");
		}else if(money > 0.0) {
			totalBalance = Integer.parseInt(ud.viewBalance(Integer.parseInt(u.toString())).toString());
			User user = new User(totalBalance + money, Integer.parseInt(u.toString()));
			csi.deposit(user);			
		}else {
			System.out.println("Please enter a valid input!\n");
			customerMenuOption();
		}		
	}
	private void viewAccountBalance() throws UserNotFoundException {
		System.out.println("Option 3 selected");
//		System.out.println("Your bank account balance is: $");
		totalBalance = Integer.parseInt(ud.viewBalance(Integer.parseInt(u.toString())).toString());
		System.out.println(csi.viewBalance(findUserIdByUsername(username)));	
		customerMenuOption();
	}



	private void acceptMoneyTransfer() {
		// TODO Auto-generated method stub
		
	}


	private void transferMoneytoAnotherAccount() {
		// TODO Auto-generated method stub
		
	}


	private void rejectBankAccount() throws UserNotFoundException {
		System.out.println("Option 1 selected");
		System.out.println("Please enter the Bank Account id you want to Reject.\n");
		System.out.println("Bank Account id");
		id = Integer.parseInt(userIn.nextLine().toString());
		esi.rejectCustomerBankAccountStatus(id);
		employeeMenuOption();		
	}

	private void AcceptBankAccount() throws UserNotFoundException {
		System.out.println("Option 2 selected");
		System.out.println("Please enter the Bank Account id you want to Accept.\n");
		System.out.println("Bank Account id");
		id = Integer.parseInt(userIn.nextLine().toString());
		esi.approveCustomerBankAccountStatus(id);
		employeeMenuOption();		
	}
	private void viewAllCustomerAccounts() throws UserNotFoundException {
		System.out.println("Option 3 selected");
		System.out.println("Now displaying all customer accounts.\n");
		System.out.println(esi.findAllCustomer());
		employeeMenuOption();
	}
	private void findUserByUserId() throws UserNotFoundException {
		System.out.println("Option 4 selected");
		System.out.println("Please enter the User Account id you want to Find.\n");
		System.out.println("User Account ID:\n");
		id = inInt(inString());
		System.out.println(esi.findAccount(id));
		employeeMenuOption();
	}
	private int findUserIdByUsername(String username) throws UserNotFoundException {
		id = inInt(inString());
		return Integer.parseInt(esi.findAccount(id).toString());
	}

	private void viewLog() {
		// TODO Auto-generated method stub
		
	}

	public void employeeLogin() throws UserNotFoundException {
		System.out.println("Option 1 selected");
		System.out.println("Please enter your username and password: \n");
		System.out.println("Username:\n");
		username = inString();
		System.out.println("Password:\n");
		password = inString();
		try {
			esi.login(username, password);
		} catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException();
		} finally {
			employeeMenuOption();
		}
	}
	public void customerLogin() throws UserNotFoundException {
		System.out.println("Option 2 selected");
		System.out.println("Please enter your username and password: \n");
		System.out.println("Username:\n");
		username = inString();
		System.out.println("Password:\n");
		password = inString();
		try {
			csi.login(username, password);
		} catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException();
		} finally {
			customerMenuOption();
		}
	}
	
	
	
	///////////////output handler//////////////////////
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
	public static double inDouble(String prompt) {
		while (true) {
			inputFlush();
			printPrompt(prompt);
			try {
				return Double.valueOf(inString().trim()).doubleValue();
			}

			catch (NumberFormatException e) {
				System.out.println("Invalid input. Not an integer");
			}
		}
	}
}

