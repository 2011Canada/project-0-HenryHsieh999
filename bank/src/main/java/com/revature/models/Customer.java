package com.revature.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.services.CustomerService;

public class Customer extends Bank{
	
	String customerUserName;
	ArrayList<Account> accounts;
	
	public Customer(double money, int bankAccountNumber) {
		super(money);
	}
	
	public Customer(double money, int bankAccountNumber, String userName) {
		this(money, bankAccountNumber);
		this.customerUserName = userName;
	}
	
	//customer applies for new bank account
	public boolean createAccount(Account account) {
		return accounts.add(account);
	}
	
	public ArrayList<Account> getBankAccounts() {
		return accounts;
	}
	//customer can get the account number
	public Account getAccountNumber(int num) {
		for(Account i : accounts) {
			if(i.getAccountID() == num) {
				return i;
			}
		}
		return null;		
	}
	
	//customer can view status of account, pending/accepted/rejected
	public Account getStatus(int num, String status) {
		for(Account i: accounts) {
			if(i.getAccountStatus() == status) {
				return i;
			}
		}
		return null;
	}
	public String getUserName() {
		return customerUserName;
	}	
}
