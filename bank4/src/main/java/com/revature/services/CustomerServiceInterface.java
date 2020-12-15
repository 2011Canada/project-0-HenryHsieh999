package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface CustomerServiceInterface {
	public User registerAccount(User u);
	public User login(String username, String password) throws UserNotFoundException;
	public User findAccount(int id);
	public User viewBalance(int id);
	public void deposit(User u);
	public void withdraw(User u);
}
