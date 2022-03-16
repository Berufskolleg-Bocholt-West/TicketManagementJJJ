package de.bkbocholtwest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.bkbocholtwest.model.App;
import de.bkbocholtwest.model.Department;
import de.bkbocholtwest.model.TicketClass;
import de.bkbocholtwest.model.User;

public class LoginAuth {
	
	private static Connection authCon;
	
	public LoginAuth(Connection appCon) {
		authCon =appCon;
	}

	
	public static void writeUsersToDatabase(String username, String password, String departmentName, int admin, String userID) {
		
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
			rs.updateString(3, departmentName);
			rs.updateInt(4, admin);
			rs.updateString(5, userID);
			rs.insertRow();                                         
			rs.moveToCurrentRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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

				Department readDep = App.dep.get(rs.getInt(3)-1);
				
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
				String name = rs.getString(2);
				System.out.println("ID: "+id+" Name: "+name	);//DepartmentName
				/*id; Members des dep; name des Departments, Tickets des Dep*/
				
				
				App.dep.add(new Department(id, name));


				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
