package de.bkbocholtwest.model;

public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public void createUser(String username, String password) {
	
		App.users.add(new User(username, password, new Department(), null));
		
	}
	
	public void deleteUser(User u) {
		App.users.remove(u);
	}

}
