package de.bkbocholtwest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.bkbocholtwest.model.App;
import de.bkbocholtwest.model.Department;
import de.bkbocholtwest.model.TicketClass;
import de.bkbocholtwest.model.TicketStatus;
import de.bkbocholtwest.model.User;

public class LoginAuth {
	
	private static Connection authCon;
	
	public LoginAuth(Connection appCon) {
		authCon =appCon;
	}

	
	public static void writeUsersToDatabase(String username, String password, int departmentID, int admin, String userID) {
		
		Statement stm = null;
		try {
			stm = authCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
			rs.updateInt(3, departmentID);
			rs.updateInt(4, admin);
			rs.updateString(5, userID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		App.users.clear();
		readUsersFromDatabase();
		// hier departmentID in Department datatype umwandeln
		
		Department readDep = App.dep.get(departmentID-1);
		
		User madeUser = new User(username, password, readDep, userID);
		App.users.add(madeUser);


	}
	public static void writeUsersToDatabase(String username, String password, int departmentID, String userID) {
		
		
		Statement stm = null;
		try {
			stm = authCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
			rs.updateInt(3, departmentID);
			rs.updateString(5, userID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		App.users.clear();
		readUsersFromDatabase();
		// hier departmentID in Department datatype umwandeln
		
		Department readDep = App.dep.get(departmentID-1);
		
		User madeUser = new User(username, password, readDep, userID);
		App.users.add(madeUser);
	}
	
	public static void readUsersFromDatabase() {
		
		Statement stm = null;
		try {
			stm = authCon.createStatement();
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

				Department readDep=null;
				
				
				for(Department rD: App.dep) {
					if(rD.getDepartmentID()==(rs.getInt(3))) {
						readDep = rD;
					
						break;
					}
				}
				
				User madeUser =new User(rs.getString(1), rs.getString(2), readDep, rs.getString(5));

				App.users.add(madeUser);
				
				readDep.getMembers().add(madeUser);

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readDepartmentFromDatabase() {
		
		Statement stm = null;
		try {
			stm = authCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;	
		try {
			rs = stm.executeQuery("SELECT * FROM Department;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				
				int id = rs.getInt(1); //DepartmentID
				String name = rs.getString(2); //DepName
				
				//System.out.println("ID: "+id+" Name: "+name);
									
				App.dep.add(new Department(id, name));


				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void readTicketsFromDatabase() {
		
		Statement stm = null;
		try {
			stm = authCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;	
		try {
			rs = stm.executeQuery("SELECT * FROM Tickets;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				
				User creator = null;
				
				for(User u: App.users) {
					if(u.getUserID()==(rs.getString(4))) {
						creator = u;
						break;
					}
				}
				
				String tickedID = rs.getString(1); 
				String description = rs.getString(2); 
				String title = rs.getString(3);
				//String creatorID = rs.getString(4);
				
				
				User.createdTickets.add(new TicketClass(tickedID, description, title, TicketStatus.DONE, creator));					

				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void writeTicketsToDatabase(String ticketID, String title, String description, TicketStatus status, String creatorID) {
		
		Statement stm = null;
		try {
			stm = authCon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stm.executeQuery("SELECT * FROM Tickets");
			rs.moveToInsertRow();                                 
			rs.updateString(1, ticketID);
			rs.updateString(2, description);
			rs.updateString(3, title);
			rs.updateString(4, creatorID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User.createdTickets.add(new TicketClass(ticketID, description, title, status, App.activeUser));
		
	}


}
