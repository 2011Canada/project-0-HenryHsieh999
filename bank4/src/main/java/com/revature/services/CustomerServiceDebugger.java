package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;

public class CustomerServiceDebugger {
	public static void main(String[] args) throws UserNotFoundException {
		UserDAO ud = new UserPostgresDAO();
//		User u = new User();
		User u = new User(0,6);
		User u3 = new User(1, 1241.12, 2, "pending");
		CustomerServicesImplementation csi = new CustomerServicesImplementation(ud);
//		System.out.println(csi.deposit(u));
//		System.out.println(csi.chkUserAccountStatus(6));
//		csi.deposit(u);
//		System.out.println(csi.findUserIdByUsername("bbbb").getUserId());
//		System.out.println(csi.viewBalance(1).getBalance());
//		System.out.println(csi.chkUserAccountType(1));
//		System.out.println(csi.newDefaultBankAccount(u));
		System.out.println(csi.transferMoneyToAnotherAccount(u3));
	}
}
