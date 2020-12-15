package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface EmployeeServiceInterface {
	public User login(String username, String password) throws UserNotFoundException;
	public User findAccount(int id);
	public void approveCustomerBankAccountStatus(int id);
	public void rejectCustomerBankAccountStatus(int id);
	public List<User> findAllCustomer();
	public List<User> findAllLockedUserAccounts();
	public List<User> findAllBankAccountsUnderSameOwner(int id);
}
