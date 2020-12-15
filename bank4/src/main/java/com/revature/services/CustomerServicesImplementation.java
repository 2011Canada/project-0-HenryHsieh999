package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.BankLauncher;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class CustomerServicesImplementation implements CustomerServiceInterface{
	
	private UserDAO ud;
	
	public CustomerServicesImplementation(UserDAO ud) {
		this.ud = ud;
	}
	public User registerAccount(User u) {
		return ud.createNewCustomerAccount(u);
	}

	public User login(String username, String password) throws UserNotFoundException {
		return ud.findUserByUsernameAndPassword(username, password);
	}

	
	public User findAccount(int id) {
		return ud.findUserByUserId(id);
	}

	
	public void deposit(User u) {
		ud.updateBankAccountBalance(u);
		BankLauncher.e720Logger.info(u.getFirstName() + " " + u.getLastName() + " " + " Deposited: $");
	}

	
	public void withdraw(User u) {
		ud.updateBankAccountBalance(u);
		BankLauncher.e720Logger.info(u.getFirstName() + " " + u.getLastName() + " " + " Withdrew: $");
	}
	
	public User viewBalance(int id) {
		return ud.viewBalance(id);

	}
	

}