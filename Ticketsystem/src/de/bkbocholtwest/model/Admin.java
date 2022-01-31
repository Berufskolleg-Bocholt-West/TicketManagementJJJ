package de.bkbocholtwest.model;

public class Admin extends User{
	
	public Admin(String username, String password, Department department) {
		super(username, password, department);
	}
	
	public void createUser(String username, String password) {
		//Hier wird der neue User in die Liste angefügt
		//App.users.add(username, password, new Department()));
		
	}
	
	public void deleteUser() {
		
	}

}
