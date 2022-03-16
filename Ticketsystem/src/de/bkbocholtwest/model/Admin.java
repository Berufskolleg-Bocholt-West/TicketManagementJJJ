package de.bkbocholtwest.model;

import de.bkbocholtwest.controller.LoginAuth;

public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public void createUser(String username, String password, int departmentID) {
		
		LoginAuth.writeUsersToDatabase(username, App.generateHash(password), departmentID, generateID());
		
		
		//second method to give admin, admin set default 0
		//LoginAuth.writeUsersToDatabase(username, App.generateHash(password), departmentID, 1, generateUserID());
		
	}
	
	public void deleteUser(User u) {
		App.users.remove(u);
		//hier user in datanbank entfernen
	}

}
