package de.bkbocholtwest.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	// Voraussetzung: Einbindung des Java-MySQL Connectors

	// Datenbankadresse und Anmeldedaten
	String url = "jdbc:mysql://localhost:3306/";
	String user = "itam-root5";
	String pass = "Mvss99?7";

	try {
	    // Verbindung aufbauen
	    Connection con = DriverManager.getConnection(url, user, pass);
	    System.out.println("Verbindung erfolgreich hergestellt");
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}

	}
}
