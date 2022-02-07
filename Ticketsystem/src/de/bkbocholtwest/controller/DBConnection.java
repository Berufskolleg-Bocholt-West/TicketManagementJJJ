package de.bkbocholtwest.controller;

import java.sql.*;

public class DBConnection {
	
	public Connection con;

	public void connect() {

		// Datenbankadresse und Anmeldedaten
		String url = "jdbc:mysql://45.81.232.17/itam-gruppe5";
		String user = "itam-root5";
		String pass = "Mvss99?7";

		try {
			// Verbindung aufbauen
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Verbindung erfolgreich hergestellt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		

	}
	
	public Connection getCon() {
		return con;
	}
	
	
	
	public DBConnection() {
		
	}

}
