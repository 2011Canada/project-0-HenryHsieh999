package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.HardBankLauncher;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class EmployeeServicesImplementation implements EmployeeServiceInterface{
	private UserDAO ud;
	
	public EmployeeServicesImplementation(UserDAO ud) {
		this.ud = ud;
	}
	
	public User login(String username, String password) throws UserNotFoundException {
		HardBankLauncher.e720Logger.info("User " + username + " has logged in");
		return ud.findUserByUsernameAndPassword(username, password);
	}

	
	public User findAccount(int id) {
		HardBankLauncher.e720Logger.debug("User Account was searched" + id);
		return ud.findUserByUserId(id);
	}
	
	
	public void approveCustomerBankAccountStatus(int id) {
		HardBankLauncher.e720Logger.debug("User Account was unlocked" + id);
		ud.approveCustomerBankAccount(id);		
	}

	
	public void rejectCustomerBankAccountStatus(int id) {
		HardBankLauncher.e720Logger.debug("User Account was locked" + id);
		ud.rejectCustomerBankAccount(id);		
	}
	
	public List<User> findAllCustomer() {
		return ud.findAllCustomer();
	}

	public List<User> findAllLockedUserAccounts() {
		return ud.findAllLockedUserAccounts();
	}

	public List<User> findAllBankAccountsUnderSameOwner(int id) {
		return ud.findAllBankAccountsUnderSameOwner(id);
	}

	public User deleteMoneyTransfer(int transferId) {

		HardBankLauncher.e720Logger.debug("Money Transfer was deleted" + transferId);
		return ud.deleteMoneyTransfer(transferId);
	}

	public User getMoneyTransferID(int userId) {
		return ud.getMoneyTransferID(userId);
	}


}