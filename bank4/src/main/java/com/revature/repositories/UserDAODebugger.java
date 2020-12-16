package com.revature.repositories;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserDAODebugger {
	public static void main(String[] args) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserDAO ud = new UserPostgresDAO();
		User u4 = new User();
		User u1 = new User("masteruser1", "secret", "henry", "hsieh");
		User u = new User(500.42, 5);
		User u3 = new User(1, 2.32, 2, "pending");
		User u2 = new User(330, 2);
//		System.out.println(ud.findUserByUsernameAndPassword("aaaa", "pword"));
//		System.out.println(ud.findAllCustomer());
//		System.out.println(ud.viewBalance(7));
//		System.out.println(ud.createNewCustomerAccount(u1));
//		System.out.println(ud.createNewBankAccount(u));
		System.out.println(ud.updateBankAccountBalance(u2));
//		System.out.println(ud.approveCustomerBankAccount(3));
//		System.out.println(ud.rejectCustomerBankAccount(3));
//		System.out.println(ud.findUserByUserId(2));
//		System.out.println(ud.findUserIdByUsername("bbbb"));
//		System.out.println(u.getUserId());
//		System.out.println(ud.updateBankAccountBalance(u2));
//		System.out.println(ud.findAllLockedUserAccounts());
//		System.out.println(ud.findAllCustomer());
//		System.out.println(ud.findAllBankAccountsUnderSameOwner(6));
//		System.out.println(ud.findAccountId(2));
//		System.out.println(ud.checkUserAccountStatus(6));
//		System.out.println(ud.moneyTransferToAnotherAccount(u3));
//		System.out.println(ud.acceptMoneyTransfer(1));
//		System.out.println(ud.deleteMoneyTransfer(2));
//		System.out.println(ud.viewAllIncomingMoneyTranfers(15));
		System.out.println(ud.viewAllOutgoingMoneyTransfers(15));
//		System.out.println(ud.getMoneyTransferID(1));
	}
}
