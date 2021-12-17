package edu.gsu.db;

import edu.gsu.common.Customer;
import edu.gsu.common.Flight;
import edu.gsu.exceptions.LoginException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

import javax.naming.directory.SearchResult;

public class DBQueryIM {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/CIS3270Project";
    private static String USN = "root";
    private static String PSW = "Dodgeraccept48@";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USN, PSW);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static void login(Customer c1) throws Exception {

        Connection conn = getConnection();

        try {
            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.login);
            
            ptmt.setString(1, c1.getUserName());
            ptmt.setString(2, c1.getPassword());

            // Execute a statement
            ResultSet rs1 = ptmt.executeQuery();

            int count = 0;

            // Iterate through the result and print the student names
            while (rs1.next()) {
                System.out.println("Number of Users:" + rs1.getInt(1));
                count = rs1.getInt(1);
            }

            if (count == 0)
                throw new LoginException("Incorrect LoginID or Password!");


        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        } finally {
            conn.close();
        }

    }

    public static String first(Customer c1) throws Exception {

        Connection conn = getConnection();
        String firstN = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.first_name);

            ptmt.setString(1, c1.getUserName());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                firstN = rs1.getNString(1);
                c1.setSecurityQ(firstN);
            }

            return firstN;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static String last(Customer c1) throws Exception {

        Connection conn = getConnection();
        String lastN = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.last_name);

            ptmt.setString(1, c1.getUserName());

            ResultSet rs1 = ptmt.executeQuery();

            while (rs1.next()) {
                lastN = rs1.getNString(1);
                c1.setSecurityQ(lastN);
            }
            return lastN;
        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }
    public static void register(Customer c1) throws Exception {

        Connection conn = getConnection();

        try {
            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.register);
            System.out.println("c1 values" + c1.toString());
            ptmt.setString(1, c1.getFirstName()); // firstName;
            ptmt.setString(2, c1.getLastName()); // lastName;
            ptmt.setString(3, c1.getUserName()); // userName;
            ptmt.setString(4, c1.getPassword()); // password;
            ptmt.setString(5, c1.getEmail()); // email;
            ptmt.setString(6, c1.getAddress()); // address;
            ptmt.setString(7, c1.getZip()); // zip;
            ptmt.setString(8, c1.getState()); // state;
            ptmt.setString(9, c1.getSSN()); // ssn;
            ptmt.setString(10, c1.getSecurityQ()); // securityQ;
            ptmt.setString(11, c1.getSecurityA()); // securityA;


            // Execute a statement
            int r1 = ptmt.executeUpdate();
            System.out.print(r1);


        } catch (Exception e) {
            System.out.print(e);
        } finally {
            conn.close();
        }

    }

    public static String question(Customer c1) throws Exception {

        Connection conn = getConnection();
        String securityq = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.question);

            ptmt.setString(1, c1.getUserName());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                securityq = rs1.getNString(1);
                c1.setSecurityQ(securityq);
            }

            return securityq;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static String password(Customer c1) throws Exception {

        Connection conn = getConnection();
        String password1 = null;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.forgot);

            ptmt.setString(1, c1.getUserName());
            ptmt.setString(2, c1.getSecurityQ());
            ptmt.setString(3, c1.getSecurityA());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
                password1 = rs1.getNString(1);
                c1.setSecurityQ(password1);
            }

            return password1;

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }

    public static ObservableList<Flight> getMyFlights(Customer c1) throws Exception {

        Connection conn = getConnection();
        System.out.println(c1.toString());
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.my_flight);

            ptmt.setInt(1, c1.getId());

            ResultSet rs1 = ptmt.executeQuery();


            while (rs1.next()) {
            	flight = new Flight(rs1.getInt("id"), rs1.getNString("airline"), 
                        rs1.getNString("dept_city"), rs1.getNString("arrival_city"),
                        rs1.getNString("dept_time"), rs1.getNString("arrival_time"),
                        rs1.getNString("date"), rs1.getInt("availability"));
                flights.add(flight);
                
            }
            

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }

    public static void delete(Customer c1, Flight f1) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ptmt = conn.prepareStatement(Queries.safe_update_0);
            ptmt.executeUpdate();

            ptmt = conn.prepareStatement(Queries.delete_flights);
            ptmt.setInt(1, f1.getFlightNo());
            ptmt.setInt(2, c1.getId());
            ptmt.executeUpdate();

            ptmt = conn.prepareStatement(Queries.safe_update_1);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }
    
    
	/*public static ObservableList<Flight> search(Flight f1) throws Exception {
        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        try {
            PreparedStatement ptmt = conn.prepareStatement(Queries.search_flight);
            
            ptmt.setString(1, f1.getAirlineName());
            ptmt.setString(2, f1.getDeparture());
            ptmt.setString(3, f1.getArrival());
            ptmt.setString(4, f1.getDate()); 
            ptmt.executeQuery(); 
            

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }   */
    
   /* public static ObservableList<Flight> search(Flight f1) throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.all_flights);

            ResultSet rs1 = ptmt.executeQuery();
            while (rs1.next()) {
                flight = new Flight(rs1.getInt("id"), rs1.getNString("airline"), 
                        rs1.getNString("dept_city"), rs1.getNString("arrival_city"),
                        rs1.getNString("dept_time"), rs1.getNString("arrival_time"),
                        rs1.getNString("date"), rs1.getInt("availability"));
                System.out.println(flight.toString());
                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    } */
    
    public static ObservableList<Flight> search
    (String air, String dep, String arr, String depD) throws Exception {

Connection conn = getConnection();
ObservableList<Flight> flights = FXCollections.observableArrayList();
Flight flight;

PreparedStatement ptmt = conn.prepareStatement(Queries.search_flight);
ResultSet rs1 = null;

try { 

		ptmt.setString(1, air);

		ptmt.setString(2, dep);

		ptmt.setString(3, arr);

		ptmt.setString(4, depD);

		rs1 = ptmt.executeQuery();
        while (rs1.next()) {
            flight = new Flight(rs1.getInt("id"), rs1.getNString("airline"),
                    rs1.getNString("dept_city"), rs1.getNString("arrival_city"),
                    rs1.getNString("dept_time"), rs1.getNString("arrival_time"),
                    rs1.getNString("date"), rs1.getInt("availability"));

            flights.add(flight);
        }
    }
catch (SQLException e) {
        System.out.println(e);
        throw e;
}

finally {
	conn.close();
}
return flights;
    }
    
    public static ObservableList<Flight> getAllFlights() throws Exception {

        Connection conn = getConnection();
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        Flight flight;

        try {

            // Create a statement
            PreparedStatement ptmt = conn.prepareStatement(Queries.all_flights);

            ResultSet rs1 = ptmt.executeQuery();
            while (rs1.next()) {
                flight = new Flight(rs1.getInt("id"), rs1.getNString("airline"), 
                        rs1.getNString("dept_city"), rs1.getNString("arrival_city"),
                        rs1.getNString("dept_time"), rs1.getNString("arrival_time"),
                        rs1.getNString("date"), rs1.getInt("availability"));
                System.out.println(flight.toString());
                flights.add(flight);
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
        return flights;
    }

    public static void book(Customer c1, Flight f1) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ptmt = conn.prepareStatement(Queries.book_flight);
            ptmt.setInt(1, c1.getId());
            ptmt.setInt(2, f1.getFlightNo());
            ptmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            throw e;

        } finally {
            conn.close();
        }
    }
}