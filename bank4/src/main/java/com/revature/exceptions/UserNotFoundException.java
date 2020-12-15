package com.revature.exceptions;

import com.revature.launcher.BankLauncher;
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(){
		super("User not found.");

	}

}