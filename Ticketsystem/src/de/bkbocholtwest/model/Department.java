package de.bkbocholtwest.model;

import java.util.ArrayList;



public class Department {
	
	private ArrayList<User> members = new ArrayList<User>();
	
	private String name;
	
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public Department() {
		
	}
}
