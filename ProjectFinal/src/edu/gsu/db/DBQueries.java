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
		// TODO Auto-generated method stub
		//post();
		//get();
		

	}
	/*
	public static ArrayList<String> get() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM register LIMIT 1");
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			while(result.next()) {
				System.out.print(result.getString("first"));
				System.out.print(" ");
				System.out.println(result.getString("second"));
				System.out.print(" ");
				System.out.println(result.getString("third"));
				
				array.add(result.getString("third"));
			}
			System.out.println("All records have been selected!");
			return array;
			
		}catch(Exception e) {System.out.println(e);}
	return null; 
	} 
	
	
	public static void post() throws Exception{
		final String var1 = " ";
		final String var2 = " ";
		final String var3 = " ";
		final String var4 = " ";
		final String var5 = " ";
		final String var6 = " ";
		final String var7 = " ";
		final String var8 = " ";
		final String var9 = " ";
		final String var10 = " ";
		final String var11 = " ";
		final String var12 = " ";
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO register (flightnum, firstname, lastname, address, zip, state, user, psw, email, ssn, securityq, securitya) VALUES (  '"+var1+"', '"+var2+"', '"+var3+"'"+var4+"', '"+var5+"', '"+var6+"'"+var7+"', '"+var8+"', '"+var9+"'"+var10+"', '"+var11+"', '"+var12+"'    )");
			
			posted.executeUpdate();
		} catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Insert Completed.");
		}
	}*/
	
	
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
	
	
	
	
	
	
	/*public static void login(Customer co) throws Exception {
			
		Connection connection = null;
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/CIS3270Project";
			String username = "root";
			String password = "Dodgeraccept48@";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);

			// Create a statement
			PreparedStatement statement = connection.prepareStatement(Queries.LOGIN);
				    
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
	
	
	public static void getFlights(Customer co) throws Exception {
		
		// can I run a query on reservation table that select all teh rows with customerID comes from co
		
		Flight f1 = new Flight();
		f1.setAirlineName("Delta 303");
		
		Flight f2 = new Flight();
		f2.setAirlineName("Delta 500");
		
		Flight f3 = new Flight();
		f3.setAirlineName("Delta 777");
		
		co.getFlights().add(f1);
		co.getFlights().add(f2);
		co.getFlights().add(f3);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Customer c0 = new Customer();
		login(c0);
		
		
	}*/
}


