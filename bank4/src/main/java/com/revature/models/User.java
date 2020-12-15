package com.revature.models;

public class User{
	
	private int userId;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String tpe;

	private double balance;
	
	private boolean status;

	public User() {
		super();
	}
	public User(int userId) {
		this.userId = userId;
	}
	public User(double balance, int userId) {
		this.balance = balance;
		this.userId = userId;
	}
	public User(double balance, boolean status, int id) {
		this.balance = balance;
		this.status = status;
		this.userId = id;
	}
	public User(String username, String password, String fName, String lName) {
		this.username = username;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
	}
	public User(String username, String password, String fName, String lName, boolean status) {
		this.username = username;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
		this.status = status;
	}
	public User(int userId, String username, String firstName, String lastName, boolean status, String tpe) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.tpe = tpe;
	}
	public User(int userId, String username, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User(int userId, String username, String password, String firstName, String lastName,boolean status, String tpe) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.tpe = tpe;
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Boolean getStatus(Boolean status) {
		return status;
	}
	
	public void setTpe(String tpe) {
		this.tpe = tpe;
	}
	
	public String getTpe() {
		return tpe;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", tpe=" + tpe + ", balance=" + balance + ", status=" + status
				+ "]";
	}	
	
}