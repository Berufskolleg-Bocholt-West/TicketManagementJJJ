package de.bkbocholtwest.model;

import java.util.ArrayList;



public class Department {
	
	private ArrayList<User> members = new ArrayList<User>();
	
	private String name;
	
	private ArrayList<TicketClass> tickets = new ArrayList<TicketClass>();
	
	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TicketClass> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<TicketClass> tickets) {
		this.tickets = tickets;
	}

	public Department() {
		
	}
}
