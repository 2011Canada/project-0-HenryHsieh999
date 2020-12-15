package com.revature.repositories;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserDAODebugger {
	public static void main(String[] args) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserDAO ud = new UserPostgresDAO();
		User u1 = new User("masteruser", "secret", "henry", "hsieh");
		User u = new User(500.42, true, 5);
		User u2 = new User(330, 2);
//		System.out.println(ud.findUserByUsernameAndPassword("aaaa", "pword"));
//		System.out.println(ud.findAllCustomer());
		System.out.println(ud.viewBalance(2));
//		System.out.println(ud.createNewCustomerAccount(u1));
//		System.out.println(ud.createNewBankAccount(u));
//		System.out.println(ud.updateBankAccountBalance(u2));
//		System.out.println(ud.approveCustomerBankAccount(3));
//		System.out.println(ud.rejectCustomerBankAccount(3));
//		System.out.println(ud.findUserByUserId(2));
	}
}
