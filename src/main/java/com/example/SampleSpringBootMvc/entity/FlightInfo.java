package com.example.SampleSpringBootMvc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight_info")
public class FlightInfo {

	@Id
	@Column(name="flight_infoid")
	private Integer flightInfoId;
	@Column(name="flight_number")
	private String flightNumber;
	@Column(name="flight_type")
	private String flightType;
	@Column(name="numberof_seats")
	private Integer numberOfSeats;
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="flights_info",
	joinColumns=@JoinColumn(name="flight_infoid"),
	inverseJoinColumns=@JoinColumn(name="airline_id"))
	private AirlineInfo airlineInfo;
	public FlightInfo()
	{
		
	}
	public FlightInfo(Integer flightInfoId, String flightNumber, String flightType, Integer numberOfSeats) {
		this.flightInfoId = flightInfoId;
		this.flightNumber = flightNumber;
		this.flightType = flightType;
		this.numberOfSeats = numberOfSeats;
	}
	public Integer getFlightInfoId() {
		return flightInfoId;
	}
	public void setFlightInfoId(Integer flightInfoId) {
		this.flightInfoId = flightInfoId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}
	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}
	@Override
	public String toString() {
		return "FlightInfo [flightInfoId=" + flightInfoId + ", flightNumber=" + flightNumber + ", flightType="
				+ flightType + ", numberOfSeats=" + numberOfSeats + "]";
	}
	
	
	
	
	

}
