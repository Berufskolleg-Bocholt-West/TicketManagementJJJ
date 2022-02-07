package de.bkbocholtwest.model;

public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public void createUser(String username, String password) {
		
		App.writeUsersToDatabase(username, App.generateHash(password), new Department().getName(), generateUserID());

	}
	
	public void deleteUser(User u) {
		App.users.remove(u);
		//hier user in datanbank entfernen
	}

}
