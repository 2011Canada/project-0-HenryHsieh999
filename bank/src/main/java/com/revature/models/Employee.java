package com.revature.models;

public class Employee extends Bank{

	String employeeUserName;
	public Employee(double money, int bankAccountNumber) {
		super(money);
	}
	
	public Employee(double money, int bankAccountNumber, String employeeUserName) {
		this(money, bankAccountNumber);
		this.employeeUserName = employeeUserName;
	}
	

}
