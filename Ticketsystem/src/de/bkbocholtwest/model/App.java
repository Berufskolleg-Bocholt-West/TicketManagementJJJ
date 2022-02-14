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

	public Connection con;
	public static User activeUser;
	public int lockCounter;
	public int attemptCounter;
	
	public int[] penaltyArray = {0,1,5,15,60}; 
	
	public Date now;
	public Date unlockTime;
	
	File dataFile = new File("Ticketsystem/src/de/bkbocholtwest/controller/Unlocktimer.txt");
    BufferedReader br;
    BufferedWriter bw;
    String lineInput;
    
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public static ArrayList<User> users = new ArrayList<User>();
	
	public App(){
		
	}
			
	public static void main(String[] args) {
		new App().path(new File("Ticketsystem/src/de/bkbocholtwest/controller/Unlocktimer.txt"));
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
		LoginAuth.readUsersFromDatabase();
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
	
	public int penalty(int lockCounter) {
		int penaltyTime = penaltyArray[lockCounter];
		now = new Date();
		unlockTime = new Date();
		unlockTime.setMinutes(unlockTime.getMinutes()+penaltyTime);
		System.out.println(unlockTime);
		String time = df.format(unlockTime);
		writer(dataFile, time);
		return penaltyTime;
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
	
	public void path(File myObj) {
		System.out.println("Absolute path: " + myObj.getAbsolutePath());
	}

}
