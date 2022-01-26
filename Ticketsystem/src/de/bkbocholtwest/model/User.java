package de.bkbocholtwest.model;

import java.util.ArrayList;

public class User {

	
	private int userID;
	private String username;
	private boolean locked;
	private String password;
	private boolean admin;
	private Department department;
	
	private ArrayList<Ticket> createdTickets = new ArrayList<Ticket>();
	private ArrayList<Ticket> pendingTickets = new ArrayList<Ticket>();
	
	
	public User(String username, int password, Department department) {
		
	}
	
	public void acceptTickets() {
		
	}
	
	public void createTickets() {
		
	}
	
	
}
