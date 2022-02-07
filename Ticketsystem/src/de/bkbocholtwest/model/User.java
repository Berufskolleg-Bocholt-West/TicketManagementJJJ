	package de.bkbocholtwest.model;

import java.util.UUID;
import java.util.ArrayList;

public class User {

	private String userID;
	private String username;
	private boolean locked;
	private String password;
	public boolean admin;
	private Department department;
	
	private ArrayList<Ticket> createdTickets = new ArrayList<Ticket>();
	private ArrayList<Ticket> pendingTickets = new ArrayList<Ticket>();
	
	public String generateUserID() {
		String userID = UUID.randomUUID().toString();
		return userID;
	}

	public User(String username, String password, Department department, String UserID) {

		this.username = username;
		this.password = password;
		this.department = department;
		this.userID = generateUserID();
	}

	public String toString() {
			
		return "UserID: "+userID+" Username: "+username +" Password: " +password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User() {
		
	}
	
	public void acceptTickets() {
		
	}
	
	public void createTickets() {
		
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
