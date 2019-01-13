/*
 * Database connection to user table,
 * check whether valid user
 */

package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	static Connection dbConnection = null;
	static Statement statement = null;
	static ResultSet result = null;
	
	private static Connection getDBConnection() {
		Connection connection = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String dbURL = "jdbc:sqlite:vehicles.sqlite";
			connection = DriverManager.getConnection(dbURL);
			return connection;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return connection;
	}
	
	private void closeConnection() {
		try {
			 if(statement != null) { statement.close(); }
			 
			 if(dbConnection!= null) { dbConnection.close(); }
			 
			 if(result != null) { result.close(); }
			 
		} catch (SQLException e) {
				e.printStackTrace();
		}	   
	}
	
	//Check validity of user, boolean output
	public Boolean usrCheck(String usr, String pass) throws SQLException {
		String query = "SELECT username, password FROM users where username = ? and password = ?";
		Boolean b = false;
		
		try {
			dbConnection = getDBConnection();
			PreparedStatement ps = dbConnection.prepareStatement(query);
		    ps.setString(1, usr);
		    ps.setString(2, pass);
		    ResultSet results = ps.executeQuery();
			
			
			if (results.next()) {
				System.out.println("Username and password exists!"); 
				b = true;
		    } else {
		    	System.out.println("Please Check Username and Password");
		    } 
			
		} catch (SQLException c) {
			System.out.println(c);
		}
		
		closeConnection();
		return b;
	}
	
}
	