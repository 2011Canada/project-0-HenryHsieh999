package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class EmployeeServicesImplementation implements EmployeeServiceInterface{
	private UserDAO ud;
	
	public EmployeeServicesImplementation(UserDAO ud) {
		this.ud = ud;
	}
	
	public User login(String username, String password) throws UserNotFoundException {
		return ud.findUserByUsernameAndPassword(username, password);
	}

	
	public User findAccount(int id) {
		return ud.findUserByUserId(id);
	}
	
	
	public void approveCustomerBankAccountStatus(int id) {
		ud.approveCustomerBankAccount(id);		
	}

	
	public void rejectCustomerBankAccountStatus(int id) {
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
		return ud.deleteMoneyTransfer(transferId);
	}

	public User getMoneyTransferID(int userId) {
		return ud.getMoneyTransferID(userId);
	}


}