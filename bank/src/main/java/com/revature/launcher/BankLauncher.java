package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.repositories.BankDAO;

public class BankLauncher {

		public static Logger bankLogger = LogManager.getLogger("com.revature.bank");
		
		public static void main(String[] args) {
//			BankDAO bd = new BankDAO();
//			BankEmployeeService bes = new BankEmployeeService(bd);
//			EmployeeBankMenu ebm = new EmployeeBankMenu(bes);
//			CustomerService cs = new CustomerService(bd);
//			CustomerBankMenu cbm = new CustomerBankMenu(cs);
			
			bankLogger.info("Server has started");
			
			while(true) {
				//the server is running
				
				System.out.println();
			}
		}
}
