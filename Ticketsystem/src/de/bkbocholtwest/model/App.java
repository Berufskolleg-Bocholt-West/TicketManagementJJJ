package de.bkbocholtwest.model;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;

import de.bkbocholtwest.controller.DBConnection;
import de.bkbocholtwest.view.Login;

public class App {

	public Connection con;
	public static User activeUser;
	public int lockCounter;
	public int attemptCounter;
	
	public static int[] penaltyArray = {0,1,5,15,60}; 
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	public App(){
		
	}
			
	public static void main(String[] args) {
		
	}
	
	public static void writeUsersToDatabase(String username, String password, String departmentName, int admin, String userID) {
		DBConnection connection = new DBConnection();
		App application = new App();
		connection.connect();
		application.con = connection.getCon();
		Statement stm = null;
		try {
			stm = application.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM User");
			rs.moveToInsertRow();                                 
			rs.updateString(1, username);
			rs.updateString(2, password);
			rs.updateString(3, departmentName);
			rs.updateInt(4, admin);
			rs.updateString(5, userID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
			
//			res = stm.executeQuery(
//					"INSERT INTO User (Username, Password, UserID)\r\n"
//					+ "VALUES ("+username+", "+password+", "+userID+");"
//					);
			//"VALUES ("+username+", "+password+", "+department+", "+admin+", "+userID+");"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void writeUsersToDatabase(String username, String password, String departmentName, String userID) {
		DBConnection connection = new DBConnection();
		App application = new App();
		connection.connect();
		application.con = connection.getCon();
		Statement stm = null;
		try {
			stm = application.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM User");
			rs.moveToInsertRow();                                 
			rs.updateString(1, username);
			rs.updateString(2, password);
			rs.updateString(3, departmentName);
			rs.updateString(5, userID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readUsersFromDatabase() {
		DBConnection conn = new DBConnection();
		App prg = new App();
		conn.connect();
		prg.con=conn.getCon();
		Statement stm = null;
		try {
			stm = prg.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM User;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){

				users.add(new User(rs.getString(1), rs.getString(2), null, rs.getString(5)));
				//System.out.println(users);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		readUsersFromDatabase();
		Admin admin = new Admin();
		//hier lesen welche User es schon gibt
		
		//admin.createUser("Johannes", "111");
		//admin.createUser("Julian", "111");

		for (User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(generateHash(password))) {
				activeUser = u;
				System.out.println(activeUser);
				lockCounter = 0;
				attemptCounter = 0;
				return true;
				
			}
		}
		attemptCounter++;
		if(attemptCounter == 3) {
			attemptCounter = 0;
			lockCounter++;
			penalty(lockCounter);
		}
		return false;
	}
	
	public static int penalty(int lockCounter) {
		int penaltyTime = penaltyArray[lockCounter];
		return penaltyTime;
	}

}
