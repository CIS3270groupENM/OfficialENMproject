package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Queries {
	
	public static final String create = 
			//"SELECT count(*) as num  FROM login_credentials WHERE username = ? AND password =?"
					"CREATE TABLE USER " +
					"id INT NOT NULL AUTO_INCREMENT," +
					"firstname varchar(255) Not Null," +
					"lastname varchar(255) Not Null," +
					"address varchar(255) Not Null," +
					"zip varchar(255) Not Null," +
					"state varchar(255) Not Null," +
					"user varchar(255) Not Null," +
					"psw varchar(255) Not Null," +
					"email varchar(255) Not Null," +
					"ssn varchar(255) Not Null," +
					"securityq varchar(255) Not Null," +
					"securitya varchar(255) Not Null," +
					"userType varchar(255) NOT NULL";
	
	public static final String flights = 
			
			"CREATE TABLE flights " +
			"id INT AUTO_INCREMENT ," +
			"airline varchar(255) Not Null," +
			"dept_city VARCHAR(255) NOT NULL," +
			"arrive_city VARCHAR(255) NOT NULL," +
			"dept_time VARCHAR(255) NOT NULL, " +
			"arrive_time VARCHAR(255) NOT NULL, " +
			"date VARCHAR(255) NOT NULL, " +
			"availability INT NOT NULL"
			
			;
	public static final String first_name =
			"SELECT firstname "
					+ "FROM User "
					+ "WHERE id = ?";
	public static final String last_name =
			"SELECT lastname "
					+ "FROM User "
					+ "WHERE id = ?";
	public static final String login =
			"SELECT count(*) as num "
					+ "FROM User "
					+ "WHERE id = ? AND psw = ?";
	public static final String register =
			"INSERT INTO User "
					+ "(firstname, lastname, id, psw, email, address, zip, state, ssn, securityq, securitya, userType) VALUES " 
					+ "(?, ?, ?, ?, ? ,? ,? ,? ,? ,?, ?," + "\"customer\"" + ")";
	public static final String forgot =
			"SELECT psw"
					+ "FROM User "
					+ "WHERE id = ? AND securityq = ? AND securitya = ?";
	public static final String question =
			"SELECT securityq "
					+ "FROM User "
					+ "WHERE id = ?";
	public static final String my_flights =
			"SELECT flights.id, airline, depart, arrive, depTime, arrTime, depDate " +
					"FROM flights JOIN tickets ON tickets.id = flights.id " +
					"WHERE flightnum IN (?)";

	public static final String delete_flights =
			"DELETE FROM tickets " +
					"WHERE (flightnum = ? AND id = ?)";

	public static final String safe_update_0 =
			"SET SQL_SAFE_UPDATES = 0";

	public static final String safe_update_1 =
			"SET SQL_SAFE_UPDATES = 1";

	public static final String flight_search =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depTime = ? AND depDate = ?)";
	public static final String flight_search_air =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ?)";

	public static final String flight_search_air_dep =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ?)";

	public static final String flight_search_air_dep_arr =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ?)";

	public static final String flight_search_air_dep_arr_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depTime = ?)";

	public static final String flight_search_air_dep_arr_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND arrive = ? AND depDate = ?)";

	public static final String flight_search_air_dep_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depTime = ?)";

	public static final String flight_search_air_dep_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_air_dep_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depart = ? AND depDate = ?)";

	public static final String flight_search_air_arr =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ?)";

	public static final String flight_search_air_arr_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depTime = ?)";

	public static final String flight_search_air_arr_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_air_arr_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND arrive = ? AND depDate = ?)";

	public static final String flight_search_air_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depTime = ?)";

	public static final String flight_search_air_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_air_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (airline = ? AND depDate = ?)";

	public static final String flight_search_dep =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ?)";

	public static final String flight_search_dep_arr =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ?)";

	public static final String flight_search_dep_arr_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depTime = ?)";

	public static final String flight_search_dep_arr_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_dep_arr_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND arrive = ? AND depDate = ?)";

	public static final String flight_search_dep_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depTime = ?)";

	public static final String flight_search_dep_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_dep_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depart = ? AND depDate = ?)";

	public static final String flight_search_arr =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ?)";

	public static final String flight_search_arr_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depTime = ?)";

	public static final String flight_search_arr_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depTime = ? AND depDate = ?)";

	public static final String flight_search_arr_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (arrive = ? AND depDate = ?)";

	public static final String flight_search_time =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depTime = ?)";

	public static final String flight_search_time_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depTime = ? AND depDate = ?)";

	public static final String flight_search_date =
			"SELECT * " +
					"FROM flights " +
					"WHERE (depDate = ?)";

	public static final String flight_search_null =
			"SELECT * FROM flights";

	public static final String all_flights =
			"SELECT * " +
					"FROM flights ";

	public static final String book_flight =
			"INSERT INTO tickets "
					+ "(royaltynumber, flightID) VALUES"
					+ "(?, ?)";
	
	
	
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

