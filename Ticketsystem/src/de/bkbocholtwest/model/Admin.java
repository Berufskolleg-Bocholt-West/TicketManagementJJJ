package de.bkbocholtwest.model;

public class Admin extends User{
	
	public Admin() {
		super();
	}
	
	public void createUser(String username, String password) {
	
		App.users.add(new User(username, App.generateHash(password), new Department()));
		//hier user in datanbank schreiben
		//gespeicherte dinge: username, gehashtes pass, department, userid
	}
	
	public void deleteUser(User u) {
		App.users.remove(u);
		//hier user in datanbank entfernen
	}

}
