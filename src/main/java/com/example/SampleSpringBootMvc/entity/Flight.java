package com.example.SampleSpringBootMvc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="flight")
public class Flight {
    
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="destination")
    private String destination;
    @Column(name="duration")
    private String duration;
    @Column(name="flight_date")
    @Temporal(TemporalType.DATE)
    private Date flightDate;
    @Column(name="flight_number")
    private String flightNumber;
    @Column(name="flight_time")
    @Temporal(TemporalType.TIME)
    private Date flightTime;
    @Column(name="origin")
    private String origin;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="fare_id")
    private Fare fare;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="flight_infoid")
    private FlightInfo flightInfo;
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="inv_id")
    private Inventory inventory;
    
    public Flight()
    {
    	
    }
    
    
	public Flight(Integer id, String destination, String duration, Date flightDate, String flightNumber,
			Date flightTime, String origin) {
		this.id = id;
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Date getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Fare getFare() {
		return fare;
	}
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	public FlightInfo getFlightInfo() {
		return flightInfo;
	}
	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", destination=" + destination + ", duration=" + duration + ", flightDate="
				+ flightDate + ", flightNumber=" + flightNumber + ", flightTime=" + flightTime + ", origin=" + origin
				+ "]";
	}
    
	
    
	
}
