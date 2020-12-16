package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.UserNotFoundException;
import com.revature.menu.MasterMenu;

public class HardBankLauncher {
	public static Logger e720Logger = LogManager.getLogger("com.revature.e720");
	
	public static void main(String[] args) throws UserNotFoundException {
		
		e720Logger.info("Server has started!");
		MasterMenu m = new MasterMenu();
		while(true) {
			m.display();
		}
	}
}