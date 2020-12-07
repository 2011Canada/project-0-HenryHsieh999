package com.revature.repositories;

import java.util.List;

import com.revature.models.Bank;

//data access object
public interface BankDAO {

	//data layer behaviors
	public Bank saveAccount(Bank b);
	
	public Bank updateBank(Bank b);
	
	//view all bank accounts
	public List<Bank> viewAllAccounts();
	
	

}
