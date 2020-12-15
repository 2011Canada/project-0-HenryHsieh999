package com.revature.models;

public class Account {
	private int accountNumber;
	private String accountUserName;
	private double balance;
	private boolean isActiveCustomerAccount;
	private int uid;
	
	public Account() {
		super();
	}
	public Account(int accountNumber, String accountUserName) {
		this.accountNumber = accountNumber;
		this.accountUserName = accountUserName;
	}
	public Account(String accountUserName, double getBalance, boolean b) {
		super();
		this.accountUserName = accountUserName;
		this.balance = getBalance;
		this.isActiveCustomerAccount = b;
	}
	

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double b) {
		this.balance = b;
	}

	public boolean isActiveCustomerAccount() {
		return isActiveCustomerAccount;
	}

	public void setActiveCustomerAccount(boolean b) {
		this.isActiveCustomerAccount = b;
	}

	public String getAccountUserName() {
		return accountUserName;
	}

	public void setAccountName(String accountName) {
		this.accountUserName = accountName;
	}

	public int getUID() {
		return uid;
	}

	public void setUID(int uid) {
		this.uid = uid;
	}
	
}