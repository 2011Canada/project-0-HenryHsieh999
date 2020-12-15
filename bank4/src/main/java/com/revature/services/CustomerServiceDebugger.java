package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;

public class CustomerServiceDebugger {
	public static void main(String[] args) throws UserNotFoundException {
		UserDAO ud = new UserPostgresDAO();
		User u = new User(355.01,1);
		CustomerServicesImplementation csi = new CustomerServicesImplementation(ud);
//		csi.withdraw(u, 3.42);
		csi.deposit(u);
	}
}
