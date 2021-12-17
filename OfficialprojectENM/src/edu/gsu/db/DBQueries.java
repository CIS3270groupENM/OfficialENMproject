package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.exceptions.LoginException;

public class DBQueries {
	
	
	public static void main(String[] args) throws Exception {

	}
	public static Connection getConnection() throws Exception {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/CIS3270Project";
			String username = "root";
			String password = "Dodgeraccept48@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {System.out.println(e);}
		
		
		return null;
	}
	public static void login(Customer co) throws Exception {
		
		Connection connection = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/CIS3270Project";
			String username = "root";
			String password = "Dodgeraccept48@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);

			// Create a statement
			PreparedStatement statement = connection.prepareStatement(Queries.login);
				    
			statement.setString(1, co.getUserName());
			statement.setString(2, co.getPassword());
				    
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			
			int count = 0;

			// Iterate through the result and print the student names
			while (resultSet.next()) {
				System.out.println("Number of Users:" + resultSet.getInt(1));
				count = resultSet.getInt(1);
			}
			
			if (count == 0)
				throw new LoginException("Invalid UserName or Password!");
				     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			
			connection.close();
		}
	}    

}


