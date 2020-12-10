package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Displayable;

public class MainMenu implements Displayable{
	
	List<Displayable> lines;
	
	Scanner userIn;
	
	public MainMenu() {
		userIn = new Scanner(System.in);
	}

	public String display() {
		String display = "";
		for(int i = 0; i < lines.size(); i++) {
			display += i + ": " + lines.get(i).display() + "\n";
		}
		return display;
	}

	public void manageUserInput() {
		String input = this.userIn.nextLine();
		int choice = Integer.parseInt(input);
		if(choice < 0 || choice > lines.size()) {
			System.out.println("Make a valid choice please!!!");
		}
		
	}
}
