package de.bkbocholtwest.model;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.*;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

import java.sql.*;

import de.bkbocholtwest.controller.DBConnection;
import de.bkbocholtwest.controller.LoginAuth;
import de.bkbocholtwest.view.Login;

public class App {

	public static Connection con;
	public static User activeUser;
	public int lockCounter;
	public int attemptCounter;
	
	public boolean isLocked;
	
	public int[] penaltyArray = {0,1,5,15,60}; 
	
	public Date readUnlockTime = new Date();
	public Date writtenUnlockTime;
	
	String lockPathStr = "src/de/bkbocholtwest/controller/Unlocktimer.txt";
	
	File dataFile = new File(lockPathStr);
    BufferedReader br;
    BufferedWriter bw;
    String lineInput;
    
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	public static ArrayList<Department> dep = new ArrayList<Department>();
	
	public App(){
		DBConnection conn = new DBConnection();
		conn.connect();
		con = conn.getCon();
		LoginAuth logAuth = new LoginAuth(con);
		pathCheck();
		checkPenalty();
		LoginAuth.readDepartmentFromDatabase();
		LoginAuth.readUsersFromDatabase();
		LoginAuth.readTicketsFromDatabase();
	
	}
			
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
	
	public int login(String username, String password) {
		if(username.equals("")||password.equals("")) {
			return 2;
		}

		for (User u : users) {
			
			if(u.getUsername().equals(username) && u.getPassword().equals(generateHash(password))) {
				activeUser = u;
				System.out.println(activeUser);
				lockCounter = 0;
				attemptCounter = 0;
				return 1;
				
			}
		}
		attemptCounter++;
		if(attemptCounter == 3) {
			attemptCounter = 0;
			lockCounter++;
			penalty(lockCounter);
		}
		return 0;
	}
	
	public int penalty(int lockCounter) {
		int penaltyTime = penaltyArray[lockCounter];
		writtenUnlockTime = new Date();
		writtenUnlockTime.setMinutes(writtenUnlockTime.getMinutes()+penaltyTime);
		String time = df.format(writtenUnlockTime);
		writer(dataFile, time);
		isLocked =true;
		return penaltyTime;
	}
	
	public Date getPenalty() {
		 
		return readUnlockTime;
	}
	
	public void checkPenalty() {
		try {
			readUnlockTime= df.parse(reader(dataFile));
		} catch (ParseException e) {
			isLocked=false;
			e.printStackTrace();
			
		}
		
		Date now = new Date();
		
		if(now.after(readUnlockTime)) {
			isLocked=false;
		}else if(readUnlockTime.after(now)) {
			isLocked =true;
		}
	}
	
	public boolean getIsLocked() {
		return isLocked;
	}
	
	public void writer(File file, String text) {
		 try {
			 	
			 
	            bw = new BufferedWriter(new FileWriter(file));

	            bw.write(text);          

	            bw.close();

	        } catch (IOException ioe) {

	            System.out.println("\n An error with the Data.txt file occured.");
	        }
	}
	
	public String reader(File file) {
		
		try {

            br = new BufferedReader(new FileReader(file));

            lineInput = br.readLine();
            

            br.close();

        } catch (IOException ioe) {

            System.out.println("\n An error with the Data.txt file occured.");
        }
		
		return lineInput;
	}
	
	public void pathCheck() {
		dataFile=path(dataFile, lockPathStr);
	}
	
	public File path(File myObj, String pathStr) {
		if(!myObj.exists()) {
			myObj = new File("Ticketsystem/" +pathStr);
		}
		return myObj;
	}

}
