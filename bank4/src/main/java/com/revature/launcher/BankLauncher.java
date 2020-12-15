package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.UserNotFoundException;
import com.revature.menu.TestMenu;
import com.revature.menu.TestMenu1;

public class BankLauncher {
	public static Logger e720Logger = LogManager.getLogger("com.revature.e720");
	
	public static void main(String[] args) throws UserNotFoundException {
		
		e720Logger.info("Server has started!");
		TestMenu1 tm = new TestMenu1();
		while(true) {
			tm.display();
		}
	}

}