package com.revature.models;

public class Customer extends User{
	
	public Customer(int userId, int accountId, String username, String firstName, String lastName, String user_status, Double balance, String tpe) {
		super(userId, accountId, firstName, lastName, user_status, balance, tpe);
	}
	public Customer(int userId, String username, String firstName,String password, String lastName, String tpe) {
		super(userId, username, firstName, lastName, tpe);
	}
	public Customer(int userId, String username, String password, String firstName, String lastName,String status, String tpe) {
		super(userId, username, password, firstName, lastName, status, tpe);
	}
	public Customer(int userId) {
		super(userId);
	}
	
}
