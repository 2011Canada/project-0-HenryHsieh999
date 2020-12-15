package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;

public class EmployeeServiceDebugger {
	public static void main(String[] args) throws UserNotFoundException {
		UserDAO ud = new UserPostgresDAO();
		EmployeeServicesImplementation esi = new EmployeeServicesImplementation(ud);
		System.out.println(esi.login("wwww", "pword1"));
	}
}
