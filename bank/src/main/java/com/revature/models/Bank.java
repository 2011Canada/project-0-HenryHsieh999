package com.revature.models;

public abstract class Bank{
	protected double money;
	private String username;
	private String password;
	private int uid;
	
	public Bank(double money) {
		this.money = money;
	}
	
	public Bank(String username, String password, int uid) {
		this.username = username;
		this.password = password;
		this.uid = 0;
	}
	
	public Bank(int id) {
		this.uid = id;
	}
	
	public int getUID() {
		return uid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
