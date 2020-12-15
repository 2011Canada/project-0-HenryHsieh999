package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
	public User findUserIdByUsername(String username) throws UserNotFoundException;
	public List<User> findAllLockedUserAccounts();
	public List<User> findAllBankAccountsUnderSameOwner(int userId);
	public User findUserByUserId(int id);
	public User findAccountId(int customerId);
	public List<User> findAllCustomer();
	public List<User> findAllEmployee();
	
	public User createNewCustomerAccount(User u);
	public User createNewBankAccount(User u);

	public User updateBankAccountBalance(User u);
	public User viewBalance(int userId);
	
	public User approveCustomerBankAccount(int userId);
	public User rejectCustomerBankAccount(int userId);
	
	public User checkUserAccountStatus(int userId);
	public User checkUserAccountType(int userId);

	public User moneyTransferToAnotherAccount(User u);

	public User acceptMoneyTransfer();
	
	//use bufferreader
//	public User viewLog();
	
}
