package com.revature.services;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerService {
	
	//Customer can see all accounts currently owned
	public List<Customer> seeAllAccounts();
	
	//Customer can view the balance of a specified account
	public void viewBalance(double vb);
	
	//Customer can withdraw specific amount
	public void withdraw(double wd);
	
	//Customer can deposit specific amount
	public void deposit(double dp);
	
	//Customer can login
	
	//Customer can post money transfer to another account
	public void transferMoney(double tm);
	
	//Customer can accept money transfer from another account
	public void acceptMoney(double am);
	

}
