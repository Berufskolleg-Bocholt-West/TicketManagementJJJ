package de.bkbocholtwest.model;

import de.bkbocholtwest.controller.LoginAuth;

public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public void createUser(String username, String password) {
		
		LoginAuth.writeUsersToDatabase(username, App.generateHash(password), new Department().getName(), generateUserID());
		
		//second method to give admin, admin set default 0
		//LoginAuth.writeUsersToDatabase(username, password, password, 1, username);
		
	}
	
	public void deleteUser(User u) {
		App.users.remove(u);
		//hier user in datanbank entfernen
	}

}
