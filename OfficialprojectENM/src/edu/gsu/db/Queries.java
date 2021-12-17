package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Queries {
	
	public static final String create = 
			//"SELECT count(*) as num  FROM login_credentials WHERE username = ? AND password =?"
					"CREATE TABLE USER " +
					"id INT PRIMARY KEY AUTO_INCREMENT," +
					"firstname varchar(255) Not Null," +
					"lastname varchar(255) Not Null," +
					"address varchar(255) Not Null," +
					"zip varchar(255) Not Null," +
					"state varchar(255) Not Null," +
					"username varchar(255) Not Null," +
					"psw varchar(255) Not Null," +
					"email varchar(255) Not Null," +
					"ssn varchar(255) Not Null," +
					"securityq varchar(255) Not Null," +
					"securitya varchar(255) Not Null," +
					"userType varchar(255) Not Null";
	
	public static final String flights = 
			
			"CREATE TABLE flights " +
			"id INT AUTO_INCREMENT ," +
			"airline VARCHAR(255) Not Null," +
			"dept_city VARCHAR(255) Not Null," +
			"arrival_city VARCHAR(255) Not Null," +
			"dept_time VARCHAR(255) Not Null, " +
			"arrival_time VARCHAR(255) Not Null, " +
			"date VARCHAR(255) Not Null, " +
			"availability INT Not Null";
			
	public static final String tickets = 
			"CREATE TABLE tickets " +
					"id INT NOT NULL AUTO_INCREMENT," +
					"userId INT  Not Null," +
					"flightId INT Not Null, PRIMARY KEY(userId, flightId)";
	
	public static final String my_flight =
				"SELECT flights.id, user.id, airline, dept_city, arrival_city, dept_city, dept_time, arrival_time, date, availability " +
				"FROM tickets JOIN flights ON tickets.flightId = flights.id JOIN USER ON USER.id = tickets.userId WHERE USER.id = ?";
	public static final String book_flight =
			"INSERT INTO tickets "
					+ "(userId, flightId) VALUES"
					+ "(?, ?)";
	public static final String search_flight =
				"SELECT *" + 
				"FROM flights WHERE (airline LIKE ? AND dept_city LIKE ? AND arrival_city LIKE ? AND date LIKE ?)";

	public static final String first_name = 
			"SELECT firstname "
					+ "FROM User "
					+ "WHERE username = ?";
	public static final String last_name =
			"SELECT lastname "
					+ "FROM User "
					+ "WHERE username = ?";
	public static final String login =
			"SELECT count(*) as num "
					+ "FROM User "
					+ "WHERE username = ? AND psw = ?";
	public static final String register =
			"INSERT INTO User "
					+ "(firstname, lastname, username, psw, email, address, zip, state, ssn, securityq, securitya, userType) VALUES " 
					+ "(?, ?, ?, ?, ? ,? ,? ,? ,? ,?, ?," + "\"customer\"" + ")";
	public static final String forgot =
			"SELECT psw "
					+ "FROM User "
					+ "WHERE username = ? AND securityq = ? AND securitya = ?";
	public static final String question =
			"SELECT securityq "
					+ "FROM User "
					+ "WHERE username = ?";
	public static final String delete_flights =
			"DELETE FROM tickets " +
					"WHERE (flightId = ? AND userId = ?)";

	public static final String safe_update_0 =
			"SET SQL_SAFE_UPDATES = 0";

	public static final String safe_update_1 =
			"SET SQL_SAFE_UPDATES = 1";

	public static final String all_flights =
			"SELECT * " +
					"FROM flights ";

	
	
	
/*public static Connection getConnection() throws Exception {
	
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
}*/
}

