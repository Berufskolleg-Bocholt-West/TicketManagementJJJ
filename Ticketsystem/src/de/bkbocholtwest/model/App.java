package de.bkbocholtwest.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.bkbocholtwest.view.Login;
public class App {

	
	public static User activeUser;
	public int lockCounter;
	public int attemptCounter;
	
	public int[] penaltyArray = {1,5,15,60}; 
	
	public static ArrayList<User> users = new ArrayList<User>();
			
			
	public static void main(String[] args) {

	}
	
	
	public static String generateHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString(
						(byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger("SHA-1").log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
	public boolean login(String username, String password) {
		Admin admin = new Admin();
		//hier lesen welche User es schon gibt
		admin.createUser("Johannes", "111");
		admin.createUser("Julian", "111");

		for (User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(generateHash(password))) {
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
