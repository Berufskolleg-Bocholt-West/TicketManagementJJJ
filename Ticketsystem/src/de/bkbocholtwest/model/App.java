package de.bkbocholtwest.model;
import java.util.ArrayList;

import de.bkbocholtwest.view.Login;
public class App {

	
	public static User activeUser;
	public int lockCounter;
	public int attemptCounter;
	
	public int[] penaltyArray = {1,5,15,60}; 
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	
			
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	public boolean login(String username, String password) {
		//User user = new User();
		users.add(new User("Johannes","111", new Department(), null));
		users.add(new User("Julian","111", new Department(), null));
		
		for (User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				activeUser = u;
				System.out.println(activeUser);
				return true;
				
			}
			
		}
		return false;
	}
	
	public void lockDeviceFor(int lockTime) {
		/*Hier an die Class Login �bergeben um damit weiterzuarbeiten.
		 * penaltyArray[lockTime]
		 */
	}

}
