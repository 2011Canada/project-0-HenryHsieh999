package com.revature.exceptions;

public class NegativeAmountException extends Exception {
	public NegativeAmountException() {
		super("Cannot enter a negative amount of money!!!");
	}
}
