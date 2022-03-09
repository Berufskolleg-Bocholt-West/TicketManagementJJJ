package de.bkbocholtwest.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.bkbocholtwest.model.App;
import de.bkbocholtwest.model.Department;
import de.bkbocholtwest.model.TicketClass;
import de.bkbocholtwest.model.User;

public class LoginAuth {
	
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
	
	public static void readUsersFromDatabase() {
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

				Department readDep = App.dep.get(rs.getInt(4)-1);
				User madeUser =new User(rs.getString(1), rs.getString(2), readDep, rs.getString(5));
				
				//App.users.add(new User(rs.getString(1), rs.getString(2), readDep, rs.getString(5)));
				App.users.add(madeUser);
				
				readDep.getMembers().add(madeUser);
				//System.out.println(users);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readDepartmentFromDatabase() {
		ArrayList<TicketClass> tickets = new ArrayList<TicketClass>();
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
