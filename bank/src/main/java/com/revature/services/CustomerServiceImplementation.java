package com.revature.services;

import java.util.List;

import com.revature.models.Bank;
import com.revature.models.Customer;

public class CustomerServiceImplementation extends GeneralBankServiceImplementation implements CustomerService{

	public List<Customer> seeAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void viewBalance(double vb) {
		// TODO Auto-generated method stub
		
	}

	public void withdraw(double wd) {
		if(wd < 0) {
			System.out.println("Please enter a number more than or equal to 0");
		} else if (balance - wd < 0) {
			System.out.println("No more money!!!");
		}
	}

	public void deposit(double dp) {
		if(dp < 0) {
			System.out.println("Please enter a number more than or equal to 0");
		}
		
	}

	public void transferMoney(double tm) {
		if(balance - tm < 0) {
			System.out.println("No more money!!!");
		}
	}

	public void acceptMoney(double am) {
		if(am < 0) {
			System.out.println("Cannot accept negative money!!!");
		}		
	}

	public Bank login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logout() {
		// TODO Auto-generated method stub
		
	}

	public Boolean newCustomerAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}



}
