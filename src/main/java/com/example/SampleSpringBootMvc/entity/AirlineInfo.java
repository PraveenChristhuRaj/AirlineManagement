package com.example.SampleSpringBootMvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airline_info")
public class AirlineInfo {

	@Id
	@Column(name="airline_id")
	private Integer airlineId;
	@Column(name="airline_logo")
	private String airlineLogo;
	@Column(name="name_of_airline")
	private String nameOfAirline;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="flights_info",
	joinColumns=@JoinColumn(name="airline_id"),
	inverseJoinColumns=@JoinColumn(name="flight_infoid"))
	private List<FlightInfo> flightInfos;
	
	public AirlineInfo()
	{
		
	}
	public AirlineInfo(Integer airlineId, String airlineLogo, String nameOfAirline) {
		this.airlineId = airlineId;
		this.airlineLogo = airlineLogo;
		this.nameOfAirline = nameOfAirline;
	}
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineLogo() {
		return airlineLogo;
	}
	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}
	public String getNameOfAirline() {
		return nameOfAirline;
	}
	public void setNameOfAirline(String nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}
	@Override
	public String toString() {
		return "AirlineInfo [airlineId=" + airlineId + ", airlineLogo=" + airlineLogo + ", nameOfAirline="
				+ nameOfAirline + "]";
	}
	public List<FlightInfo> getFlightInfos() {
		return flightInfos;
	}
	public void setFlightInfos(List<FlightInfo> flightInfos) {
		this.flightInfos = flightInfos;
	}
	public void addFlight(FlightInfo flightInfo)
	{
		if(flightInfos == null)
		{
			flightInfos = new ArrayList<>();
		}
		flightInfos.add(flightInfo);
	}
	
	
}
