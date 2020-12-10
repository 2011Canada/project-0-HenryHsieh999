package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Displayable;

public class CustomerBankMenu implements Displayable{
	
	List<Displayable> lines;
	
	Scanner userIn;

	public String display() {
		String display = "";
		
		return display;
	}
	
	public void manageUserInput() {
		String input = this.userIn.nextLine();
		
		
	}
	
}
