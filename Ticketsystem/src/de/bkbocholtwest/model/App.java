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
		Admin admin = new Admin();
		//hier lesen welche User es schon gibt
		admin.createUser("Johannes", "111");
		admin.createUser("Julian", "111");

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
		/*Hier an die Class Login übergeben um damit weiterzuarbeiten.
		 * penaltyArray[lockTime]
		 */
	}

}
