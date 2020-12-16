package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.launcher.HardBankLauncher;
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
	public User newDefaultBankAccount(User u) {
		return ud.createNewBankAccount(u);
	}
	public User login(String username, String password) throws UserNotFoundException {
		HardBankLauncher.e720Logger.info("User " + username + " has logged in");
		return ud.findUserByUsernameAndPassword(username, password);
	}

	
	public User findAccount(int id) {
		HardBankLauncher.e720Logger.debug("User Account was searched " + id);
		return ud.findUserByUserId(id);
	}

	
	public User deposit(User u) {
		return ud.updateBankAccountBalance(u);
		
	}

	
	public User withdraw(User u) {
		return ud.updateBankAccountBalance(u);
	}
	
	public User viewBalance(int id) {
		return ud.viewBalance(id);

	}
	public User findUserIdByUsername(String username) throws UserNotFoundException {
		return ud.findUserIdByUsername(username);
	}

	public User chkUserAccountStatus(int id) {
		HardBankLauncher.e720Logger.debug("User account status was checked. User id = " + id);
		return ud.checkUserAccountStatus(id);
	}

	public User chkUserAccountType(int id) {
		HardBankLauncher.e720Logger.debug("User account type was checked. User id = " + id);
		return ud.checkUserAccountType(id);
	}
	public User acceptMoneyTransferFromAnotherUser(int transferId) {
		HardBankLauncher.e720Logger.debug("User accepted money from transferID" + transferId);
		return ud.acceptMoneyTransfer(transferId);
	}
	public User transferMoneyToAnotherAccount(User u) {
		HardBankLauncher.e720Logger.info(u.getFirstName() + " " + u.getLastName() + " " + "is trying to transfer money.");
		return ud.moneyTransferToAnotherAccount(u);
	}

	public User getMoneyTransferID(int userId) {
		return ud.getMoneyTransferID(userId);
	}
	public List<User> viewAllIncomingMoneyTranfers(int userId) {
		HardBankLauncher.e720Logger.debug("User viewed all incoming money transfers" + userId);
		return ud.viewAllIncomingMoneyTranfers(userId);
	}

	public List<User> viewAllOutgoingMoneyTransfers(int userId) {
		HardBankLauncher.e720Logger.debug("User viewed all outgoing money transfers" + userId);
		return ud.viewAllOutgoingMoneyTransfers(userId);
	}

	@Override
	public User updateBalance(User u) {
		HardBankLauncher.e720Logger.debug("User viewed updated their account balance" + u);
		return ud.updateBankAccountBalance(u);
	}


}