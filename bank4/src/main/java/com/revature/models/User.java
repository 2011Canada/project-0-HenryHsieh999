package com.revature.models;

public class User{
	
	private int userId;
	private int accountId;
	private double balance;
	private int receiverAccountID;
	private int senderAccountID;
	private double tempMoneyTransfer;
	private String transferState;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String tpe;
	private String userAccountStatus;
	
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
	public User(double balance, String userAccountStatus, int id) {
		this.balance = balance;
		this.userAccountStatus = userAccountStatus;
		this.userId = id;
	}
	public User(String username, String password, String fName, String lName) {
		this.username = username;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
	}
	public User(String username, String password, String fName, String lName, String userAccountStatus) {
		this.username = username;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
		this.userAccountStatus = userAccountStatus;
	}
	public User(int userId, String username, String firstName, String lastName, String userAccountStatus, String tpe) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
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
	public User(int userId, String username, String password, String firstName, String lastName,String userAccountStatus, String tpe) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userAccountStatus = userAccountStatus;
		this.tpe = tpe;
	}
	
	public User(String userAccountStatus) {
		super();
		this.userAccountStatus = userAccountStatus;
	}
	public User(int id, int accountId, String firstName, String lastName, String user_status, Double balance, String tpe) {
		super();
		this.userId = id;
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userAccountStatus = user_status;
		this.balance = balance;
		this.tpe = tpe;
	}
	
	public User(int receiverAccountID, double balance, int senderAccountID, String transferState) {
		super();
		this.receiverAccountID = receiverAccountID;
		this.balance = balance;
		this.senderAccountID = senderAccountID;
		this.transferState = transferState;
	}
	public User(int receiverAccountID, double tempMoneyTransfer, int senderAccountID) {
		super();
		this.receiverAccountID = receiverAccountID;
		this.tempMoneyTransfer = tempMoneyTransfer;
		this.senderAccountID = senderAccountID;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getReceiverAccountID() {
		return receiverAccountID;
	}
	public void setReceiverAccountID(int receiverAccountID) {
		this.receiverAccountID = receiverAccountID;
	}
	public int getSenderAccountID() {
		return senderAccountID;
	}
	public void setSenderAccountID(int senderAccountID) {
		this.senderAccountID = senderAccountID;
	}
	public double getBalance() {
		return balance;
	}
	public Double getTempMoneyTransfer() {
		return tempMoneyTransfer;
	}

	public void setTempMoneyTransfer(double tempMoneyTransfer) {
		this.tempMoneyTransfer = tempMoneyTransfer;
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
	
	public void setUserAccountStatus(String userAccountStatus) {
		this.userAccountStatus = userAccountStatus;
	}
	
	public String getUserAccountStatus() {
		return userAccountStatus;
	}
	
	public void setTpe(String tpe) {
		this.tpe = tpe;
	}
	
	public String getTpe() {
		return tpe;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", accountId=" + accountId + ", balance=" + balance + ", receiverAccountID="
				+ receiverAccountID + ", senderAccountID=" + senderAccountID + ", transferState=" + transferState
				+ ", username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", tpe=" + tpe + ", userAccountStatus=" + userAccountStatus + "]";
	}
	
	


	
}