package com.revature.services;

import com.revature.models.Bank;

public interface GeneralBankServiceInterface {
	public Bank login(String username, String password);
	public void logout();
	public Boolean newCustomerAccount(String username, String password);
	
}
