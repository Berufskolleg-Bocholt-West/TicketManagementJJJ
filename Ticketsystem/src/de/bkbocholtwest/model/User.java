	package de.bkbocholtwest.model;

import java.util.UUID;

import de.bkbocholtwest.controller.LoginAuth;

import java.util.ArrayList;

public class User {

	private String userID;
	private String username;
	private boolean locked;
	private String password;
	public boolean admin;
	private Department department;
	
	public static ArrayList<TicketClass> createdTickets = new ArrayList<TicketClass>();
	public static ArrayList<TicketClass> pendingTickets = new ArrayList<TicketClass>();
	
	public String generateID() {
		String userID = UUID.randomUUID().toString();
		return userID;
	}

	public User(String username, String password, Department department, String UserID) {

		this.username = username;
		this.password = password;
		this.department = department;
		this.userID = UserID;
	}
	
	public String getUserID() {
		return userID;
		
	}
	public void Logout() {
		App.activeUser = null;
		createdTickets.clear();
		pendingTickets.clear();
		LoginAuth.readTicketsFromDatabase();
	}
	
	public String toString() {
			
		return "UserID: "+userID+"\nUsername: "+username +"\nPassword: " +password + "\nDepartment:" + department.getName();
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
	
	public void createTickets(String description, String title, TicketStatus status) {
		LoginAuth.writeTicketsToDatabase(TicketClass.generateTicketID(), title, description, status, App.activeUser.getUserID());
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
