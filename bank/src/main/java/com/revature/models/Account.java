package com.revature.models;

public class Account {
	String owner;
	String accountStatus;
	int accountID;
	double balance;
//	AccountState accountState = AccountState.PENDING;
	
	
	public Account() {
		this.balance = 0;
		this.accountID = 0;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	public int getAccountID() {
		return accountID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
