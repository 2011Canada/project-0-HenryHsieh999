package com.revature.menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.TransformerFactoryConfigurationError;

import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.HardBankLauncher;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.CustomerServicesImplementation;
import com.revature.services.EmployeeServicesImplementation;

public class MasterMenu {	
	static boolean employeeFlag;
	static String username = "";
	static String password = "";
	static String fname = "";
	static String lname = "";
	static String yn = "";
	static double money = 0;
	static double totalBalance = 0;
	static double currentBalance = 0;
	
	static double tempMoneyTransfer = 0;
	static int receiverAccountID = 0;
	static int senderAccountID = 0;
	static int transferIDs = 0;
	
	static UserPostgresDAO uPDAO;
	static User u;
	static int currentUserId = -10;
	static int BankAccountId = -10;
	static int userTempIdForEmployeeManipulation = -10;
	static int state = 0;
	static int menuState = 0;
	static String currentBankAccountState = "inactive";
	UserDAO ud = new UserPostgresDAO();
	CustomerServicesImplementation csi = new CustomerServicesImplementation(ud);
	EmployeeServicesImplementation esi = new EmployeeServicesImplementation(ud);
	Scanner userIn;
	List<User> uList;
	MasterMenu tm;
	static int selection = 0;
	
	public void display() throws UserNotFoundException {
		System.out.println("--------------------------------");
		System.out.println("|     WELCOME TO HARD BANK     |");
		System.out.println("| WHERE WE PLAY WITH YOUR MONEY|");
		System.out.println("--------------------------------");

		while(true) {
			System.out.println("------------------------------");
			System.out.println("|                            |");
			System.out.println("| Login Options:             |");
			System.out.println("|        1. Employee         |");
			System.out.println("|        2. Customer         |");
			System.out.println("|        3. New Customer     |");
			System.out.println("|        4. Exit             |");
			System.out.println("------------------------------");
			state = inInt("login options:"); 
			switch(state){
				case 1:
					try {
						employeeLogin();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot login!");
						System.out.println("Cannot login please try again!");
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						customerLogin();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot login!");
						System.out.println("Cannot login please try again!");
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						newCustomerCreateAccountMenu();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot create new Customer");
						System.out.println("Cannot create new Customer please try again!");
						e.printStackTrace();
					}
					break;
				case 4:
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
			System.out.println("-------------------------------------------");
			System.out.println("|                                         |");
			System.out.println("| Employee Options:                       |");
			System.out.println("|  1. RejectBankAccount                   |");
			System.out.println("|  2. AcceptBankAccount                   |");
			System.out.println("|  3. ViewAllCustomerAccounts             |");
			System.out.println("|  4. findUserByUserId                    |");
			System.out.println("|  5. View Log                            |");
			System.out.println("|  6. Logout                              |");
			System.out.println("|  7. Exit Hard Bank Application          |");
			System.out.println("-------------------------------------------");
			state = inInt("Employee options:"); 
			switch(state){
				case 1:
					try {
						rejectBankAccount();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot Reject Bank Account");
						System.out.println("Cannot Reject Bank Account please try again!");
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						AcceptBankAccount();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot Accept Bank Account");
						System.out.println("Cannot Accept Bank Account please try again!");
						e.printStackTrace();
					}	
					break;
				case 3:
					try {
						viewAllCustomerAccounts();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot view all customer Accounts");
						System.out.println("Cannot view all customer Accounts please try again!");
						e.printStackTrace();
					}	
					break;
				case 4:
					try {
						findUserByUserId();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot find user by user Id");
						System.out.println("Cannot find user by user Id please try again!");
						e.printStackTrace();
					}	
					break;
				case 5:
					try {
						viewLog();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot view log!");
						e.printStackTrace();
					}
					break;
				case 6:
					HardBankLauncher.e720Logger.info("User " + username + " has logged out");
					System.out.println("You have logged out!");
					display();
					break;
				case 7:
					System.out.println("You should really log out before you exit the application!!!");
					System.exit(0);
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
			System.out.println("|  5. See All Incoming Money Transfers    |");
			System.out.println("|  6. See All Outgoing Money Transfers    |");
			System.out.println("|  7. Transfer Money to another account   |");			
			System.out.println("|  8. Logout                              |");
			System.out.println("|  9. Exit Hard Bank Application          |");
			System.out.println("-------------------------------------------");
			state = inInt("Customer options:");  
			switch(state){
				case 1:
					try {
						withdraw();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot withdraw amount");
						System.out.println("Cannot withdraw amount please try again!");
						e.printStackTrace();
					}	
					break;
				case 2:
					try {
						deposit();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot deposit amount");
						System.out.println("Cannot deposit amount please try again!");
						e.printStackTrace();
					}	
					break;
				case 3:
					try {
						viewAccountBalance();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot view Account Balance");
						System.out.println("Cannot view Account Balance please try again!");
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						acceptMoneyTransfer();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot accept Money Transfer");
						System.out.println("Cannot accept Money Transfer please try again!");
						e.printStackTrace();
					}

					break;
				case 5:
					try {
						seeAllIncomingMoneyTransfers();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot see All Incoming Money Transfers");
						System.out.println("Cannot see All Incoming Money Transfers please try again!");
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						seeAllOutGoingMoneyTransfers();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot see All Out Going Money Transfers");
						System.out.println("Cannot see All Out Going Money Transfers please try again!");
						e.printStackTrace();
					}
					break;
				case 7:
					try {
						transferMoneytoAnotherAccount();
					} catch (Exception e) {
						HardBankLauncher.e720Logger.debug("Cannot transfer Money to Another Account");
						System.out.println("Cannot transfer Money to Another Account please try again!");
						e.printStackTrace();
					}
					break;
				case 8:
					HardBankLauncher.e720Logger.info("User " + username + " has logged out");
					System.out.println("You have logged out!\n");
					display();
					break;
				case 9:
					System.out.println("You should really log out before you exit the application!!!");
					System.exit(0);
					break;
				default:
					System.out.println("Please make a valid selection\n");
					break;
				}
		}
	}
	private void withdraw() throws UserNotFoundException {
		System.out.println("Option 1 selected\n");
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Please enter the amount of money you would like to withdraw.\n");
		money = Double.parseDouble(inString());
		System.out.println("You have chosen to withdraw: " + money);
		if(money <= 0.0) {
			money = 0;
			System.out.println("Please enter an amount greater than 0!\n");
			withdraw();
		}else if(money > 0.0) {
			totalBalance = csi.viewBalance(currentUserId).getBalance();
			if(totalBalance + money < 0) {
				System.out.println("Our bank does not allow for overdraft! We are a bank with moral!");					
			}
			User user = new User(totalBalance - money, currentUserId);
			csi.withdraw(user);
			System.out.println("Your remaining balance is: $" + csi.viewBalance(currentUserId).getBalance());
		}else {
			System.out.println("Please enter an amount greater than 0!\n");
			customerMenuOption();
		}
	}
	private void deposit() throws UserNotFoundException {
		System.out.println("Option 2 selected\n");
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Please enter the amount of money you would like to deposit.\n");
		money = Double.parseDouble(inString());
		System.out.println("You have chosen to deposit: " + money);
		if(money <= 0.0) {
			money = 0;
			System.out.println("Please enter an amount greater than 0!\n");
			deposit();
		}else if(money > 0.0) {
			totalBalance = csi.viewBalance(currentUserId).getBalance();
			User user = new User(totalBalance + money, currentUserId);
			csi.deposit(user);
			System.out.println("Your remaining balance is: $" + csi.viewBalance(currentUserId).getBalance());
		}else {
			System.out.println("Please enter an amount greater than 0!\n");
			customerMenuOption();
		}		
	}
	private void viewAccountBalance() throws UserNotFoundException {
		System.out.println("Current user id is : \n" + currentUserId);
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Option 3 selected!");
		totalBalance = csi.viewBalance(currentUserId).getBalance();
		System.out.println("Your bank account balance is: $" + totalBalance);
		customerMenuOption();
	}
	private void acceptMoneyTransfer() throws UserNotFoundException {
		System.out.println("Current user id is : \n" + currentUserId);
		System.out.println("Option 4 selected!");
		currentUserId = csi.findUserIdByUsername(username).getUserId();
		System.out.println("Are you sure you want to accept this money?");
		System.out.println("Are you sure you want to accept this money?\n1.Confirm\n2.Decline");
		if(inString().equals("1")) {
			System.out.println("Please enter the transfer ID you would like to accept!");
			transferIDs = Integer.parseInt(inString());
			csi.acceptMoneyTransferFromAnotherUser(transferIDs);
			System.out.println("You have finished accepting the money!");
			totalBalance = csi.viewBalance(currentUserId).getBalance();
			System.out.println("You now have a balance of: $" + totalBalance);
			esi.deleteMoneyTransfer(transferIDs);
			customerMenuOption();
		}else if(inString().equals("2")) {
			System.out.println("You have declined to accept the money! Such a nice person!");
			
			customerMenuOption();
		}else {
			System.out.println("Please enter either 1 or 2!!! Hard Bank no like bad choices!");
			customerMenuOption();
		}
	}
	private void seeAllIncomingMoneyTransfers() throws UserNotFoundException {
		System.out.println("Current user id is : \n" + currentUserId);
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Option 5 selected!");
		System.out.println(csi.viewAllIncomingMoneyTranfers(BankAccountId));
		customerMenuOption();	
	}
	
	private void seeAllOutGoingMoneyTransfers() throws UserNotFoundException {
		System.out.println("Current user id is : \n" + currentUserId);
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Option 6 selected!");
		currentUserId = csi.findUserIdByUsername(username).getUserId();
		System.out.println(csi.viewAllOutgoingMoneyTransfers(BankAccountId));
		customerMenuOption();
	}
	private void transferMoneytoAnotherAccount() {
		System.out.println("Current user id is : \n" + currentUserId);
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		System.out.println("Option 7 selected!");
		System.out.println("Please enter the Receiver's bank account ID!");
		receiverAccountID = Integer.parseInt(inString());
		System.out.println("Please enter the Sender's bank account ID");
		senderAccountID = Integer.parseInt(inString());
		System.out.println("Please enter the balance you want to send: $");
		tempMoneyTransfer = Double.parseDouble(inString());
		//check for negative amount entered
		currentBalance = csi.viewBalance(currentUserId).getBalance();
		if(tempMoneyTransfer <= 0) {
			System.out.println("Please enter a amount more than 0!");
			transferMoneytoAnotherAccount();
		}else if((currentBalance - tempMoneyTransfer) < 0) {
			System.out.println("You are going into overdraft! You will pay interest daily! Hard Bank loves your money!");
			User u = new User(receiverAccountID, tempMoneyTransfer, senderAccountID);
			csi.transferMoneyToAnotherAccount(u);
			totalBalance = csi.viewBalance(currentUserId).getBalance();
			totalBalance = totalBalance - tempMoneyTransfer;
			User user = new User(totalBalance, currentUserId);
			csi.updateBalance(user);
			System.out.println("You're transfer of: $" + tempMoneyTransfer + " is now pending!");
			System.out.println("You now have: $" + totalBalance + " in BankAccountId: " + BankAccountId);
		}else if((currentBalance - tempMoneyTransfer) > 0) {
			System.out.println("You're transfer of: $" + tempMoneyTransfer + " is now pending!");
			User u2 = new User(receiverAccountID, tempMoneyTransfer, senderAccountID);
			totalBalance = csi.viewBalance(currentUserId).getBalance();
			totalBalance = totalBalance - tempMoneyTransfer;
			User user = new User(totalBalance, currentUserId);
			csi.updateBalance(user);
			System.out.println("You now have: $" + totalBalance + " in " + "Bank Account id:" + BankAccountId);
			csi.transferMoneyToAnotherAccount(u2);
			try {
				customerMenuOption();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			customerMenuOption();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	private void rejectBankAccount() throws UserNotFoundException {
		System.out.println("Option 1 selected");
		System.out.println("Please enter the User Account ID you want to Reject.\n");
		System.out.println("User Account ID:");
		userTempIdForEmployeeManipulation = Integer.parseInt(inString());
		esi.rejectCustomerBankAccountStatus(userTempIdForEmployeeManipulation);
		System.out.println("Operation finished, returning to employee menu.\n");
		employeeMenuOption();		
	}

	private void AcceptBankAccount() throws UserNotFoundException {
		System.out.println("Option 2 selected");
		System.out.println("Please enter the User Account ID you want to Accept.");
		System.out.println("User Account ID");
		userTempIdForEmployeeManipulation = Integer.parseInt(inString());
		esi.approveCustomerBankAccountStatus(userTempIdForEmployeeManipulation);
		System.out.println("Operation finished, returning to employee menu.\n");
		
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
		userTempIdForEmployeeManipulation = Integer.parseInt(inString());
		System.out.println(esi.findAccount(userTempIdForEmployeeManipulation));
		employeeMenuOption();
	} 

	private void viewLog() throws Exception, IOException {
		List<String> list = new ArrayList<>();
		FileReader fr = new FileReader("C:\\Users\\Henry\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\bank4\\logs\\trace.log");
		try(BufferedReader br = new BufferedReader(fr)){
			String strCurrentLine;
			while((strCurrentLine = br.readLine()) != null) {
				System.out.println(strCurrentLine);
		}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	public void employeeLogin() throws UserNotFoundException {
		System.out.println("Option 1 selected");
		System.out.println("Please enter your username and password: \n");
		System.out.println("Username:\n");
		username = inString();
		System.out.println("Password:\n");
		password = inString();
		currentUserId = ud.findUserIdByUsername(username).getUserId();
		System.out.println("Current user id is : \n" + currentUserId);
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
		currentUserId = ud.findUserIdByUsername(username).getUserId();
		System.out.println("Current user id is : \n" + currentUserId);
		BankAccountId = ud.findAccountId(currentUserId).getAccountId();
		System.out.println("Current Bank Account Id is: \n" + BankAccountId);
		try {
			csi.login(username, password);
			if(csi.chkUserAccountStatus(currentUserId).getUserAccountStatus().equals("inactive")) {
				System.out.println("Your account is currently locked. Please visit a branch for inquiries!");
				display();
			}else if(csi.chkUserAccountType(currentUserId).getTpe().equals("employee")) {
				System.out.println("You are not an employee! You don't get to take rob people!");
				display();
			}else if(csi.chkUserAccountType(currentUserId).getTpe().equals("customer")) {
//				fname = ud.findAccountId(currentUserId).getFirstName();
//				lname = ud.findUserIdByUsername(username).getLastName();
				System.out.println("Welcome back to Hard Bank!");
//				System.out.println("First name: " + fname + " Last name: " + lname);
				customerMenuOption();
			}
		} catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new UserNotFoundException();
		} 
	}
	private void newCustomerCreateAccountMenu() throws UserNotFoundException {
		System.out.println("Option 3 selected");
		System.out.println("Please enter your username and password: \n");
		System.out.println("Username:\n");
		username = inString();
		System.out.println("Password:\n");
		password = inString();
		System.out.println("Please enter your First Name and Last Name: \n");
		System.out.println("First Name: \n");
		fname = inString();
		System.out.println("Last Name: \n");
		lname = inString();
		User u = new User(username, password, fname, lname);
		try {
			csi.registerAccount(u);
		} finally {

			System.out.println("Thank you for registering at Hard Bank!");
			System.out.println("Please wait a moment while we create your account!");
			User u1 = new User(0, csi.findUserIdByUsername(username).getUserId());
			csi.newDefaultBankAccount(u1);
			display();
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

