package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
	public User createNewCustomerAccount(User u);
	public User findUserByUserId(int id);
	public User createNewBankAccount(User u);
	public User updateBankAccountBalance(User u);
	public User viewBalance(int userId);
	public User approveCustomerBankAccount(int userId);
	public User rejectCustomerBankAccount(int userId);
//	public User moneyTransferToAnotherAccount();
//	public User acceptMoneyTransfer();
	public List<User> findAllCustomer();
//	public User viewLog();
}
