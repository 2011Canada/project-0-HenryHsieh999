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
	public Customer(int receiver_account_id, double tempMoneyTransfer, int sender_account_id, String money_transfer_status, int transfer_id) {
		super(receiver_account_id, tempMoneyTransfer, sender_account_id, money_transfer_status, transfer_id);
	}
	public Customer(int receiverAccountId, double tempMoneyTransfer, int senderAccountId , String moneyTransferStatus, int transferId , int accountId) {
		super(receiverAccountId, tempMoneyTransfer,senderAccountId,moneyTransferStatus,transferId,accountId);
	}
	
}
