package edu.gsu.common;

import edu.gsu.db.DBQueryIM;
import javafx.collections.ObservableList;

public class Flight {
	private int flightNo;
	private String airlineName;
	private String departure;
	private String arrival;
	private String depTime;
	private String arrTime;
	private String date;
	private int availability;
	
	
	   

	public Flight(int flightNo, String airlineName, String departure, String arrival, String depTime,
			String arrTime, String date, int availability) {
		super();
		this.flightNo = flightNo;
		this.airlineName = airlineName;
		this.departure = departure;
		this.arrival = arrival;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.date = date;
		this.availability = availability;
	}

	public Flight(){
	    }

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", airlineName=" + airlineName + ", departure=" + departure
				+ ", arrival=" + arrival + ", depTime=" + depTime + ", arrTime=" + arrTime + ", date=" + date
				+ ", availability=" + availability + "]";
	}

	
}
