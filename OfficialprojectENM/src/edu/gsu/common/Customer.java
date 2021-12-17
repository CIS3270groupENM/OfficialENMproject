package edu.gsu.common;

import java.util.ArrayList;

public class Customer {
	
	private int id;
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setEmail(String email) {
		this.email = email;
	}
    public String getAddress() {
        return address;
    }
	public void setAddress(String address) {
		this.address = address;
	}
    public String getZip() {
        return zip;
    }
	public void setZip(String zip) {
		this.zip = zip;
	}
    public String getState() {
        return state;
    }
	public void setState(String state) {
		this.state = state;
	}
    public String getSSN() {
        return ssn;
    }
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
    public String getSecurityQ() {
        return securityq;
    }
	public void setSecurityQ(String securityq) {
		this.securityq = securityq;
	}
    public String getSecurityA() {
        return securitya;
    }
	public void setSecurityA(String securitya) {
		this.securitya = securitya;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", flights="
				+ flights + ", action=" + action + ", email=" + email + ", address=" + address + ", zip=" + zip
				+ ", state=" + state + ", ssn=" + ssn + ", securityq=" + securityq + ", securitya=" + securitya + "]";
	}
}

	

//final