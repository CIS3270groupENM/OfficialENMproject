package edu.gsu.common;

import java.util.ArrayList;

public class Customer {
	
	private int customerID;
	private String flightNum;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private ArrayList<Flight> flights;
	private String action;
	private String email;
	private String address;
	private String zip;
	private String state;
	private String ssn;
	private String securityq;
	private String securitya;
	
	
	public Customer() {
		
		flights = new ArrayList<>();
	}
	
	public String getflightNum() {
			return flightNum;
		}
	public void setflightNum(String flightnum) {
		this.flightNum = flightnum;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
    public String getEmail() {
        return email;
    }
	public void setEmail(String action) {
		this.email = email;
	}
    public String getAddress() {
        return email;
    }
	public void setAddress(String action) {
		this.address = address;
	}
    public String getZip() {
        return email;
    }
	public void setZip(String action) {
		this.zip = zip;
	}
    public String getState() {
        return email;
    }
	public void setState(String action) {
		this.state = state;
	}
    public String getSSN() {
        return email;
    }
	public void setSSN(String action) {
		this.ssn = ssn;
	}
    public String getSecurityQ() {
        return email;
    }
	public void setSecurityQ(String action) {
		this.securityq = securityq;
	}
    public String getSecurityA() {
        return email;
    }
	public void setSecurityA(String action) {
		this.securitya = securitya;
	}
}

	
