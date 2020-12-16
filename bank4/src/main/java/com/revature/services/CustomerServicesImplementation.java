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
		return ud.findUserByUsernameAndPassword(username, password);
	}

	
	public User findAccount(int id) {
		return ud.findUserByUserId(id);
	}

	
	public User deposit(User u) {
		return ud.updateBankAccountBalance(u);
		
//		BankLauncher.e720Logger.info(u.getFirstName() + " " + u.getLastName() + " " + " Deposited: $");
	}

	
	public User withdraw(User u) {
		return ud.updateBankAccountBalance(u);
//		BankLauncher.e720Logger.info(u.getFirstName() + " " + u.getLastName() + " " + " Withdrew: $");
	}
	
	public User viewBalance(int id) {
		return ud.viewBalance(id);

	}
	public User findUserIdByUsername(String username) throws UserNotFoundException {
		return ud.findUserIdByUsername(username);
	}

	public User chkUserAccountStatus(int id) {
		return ud.checkUserAccountStatus(id);
	}

	public User chkUserAccountType(int id) {
		return ud.checkUserAccountType(id);
	}
	public User acceptMoneyTransferFromAnotherUser(int transferId) {
	return ud.acceptMoneyTransfer(transferId);
	}
	public User transferMoneyToAnotherAccount(User u) {
		return ud.moneyTransferToAnotherAccount(u);
	}

	public User getMoneyTransferID(int userId) {
		return ud.getMoneyTransferID(userId);
	}
	public List<User> viewAllIncomingMoneyTranfers(int userId) {
		return ud.viewAllIncomingMoneyTranfers(userId);
	}

	public List<User> viewAllOutgoingMoneyTransfers(int userId) {
		return ud.viewAllOutgoingMoneyTransfers(userId);
	}




	

}