package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface CustomerServiceInterface {
	public User registerAccount(User u);
	public User newDefaultBankAccount(User u);
	public User login(String username, String password) throws UserNotFoundException;
	public User findAccount(int id);
	public User findUserIdByUsername(String username) throws UserNotFoundException;
	public User updateBalance(User u);
	public User viewBalance(int id);
	public User deposit(User u);
	public User withdraw(User u);
	public User chkUserAccountStatus(int id);
	public User chkUserAccountType(int id);
	public User transferMoneyToAnotherAccount(User u);
	public User acceptMoneyTransferFromAnotherUser(int transferId);
	public User getMoneyTransferID(int userId);
	
	public List<User> viewAllIncomingMoneyTranfers(int userId);
	public List<User> viewAllOutgoingMoneyTransfers(int userId);
}
