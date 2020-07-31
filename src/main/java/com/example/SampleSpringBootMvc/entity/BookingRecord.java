package com.example.SampleSpringBootMvc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="booking_record")
public class BookingRecord {
    @Id
    @Column(name="booking_id")
	private Integer bookingId;
	@Column(name="booking_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	@Column(name="destination")
	private String destination;
	@Column(name="fare")
	private Double fare;
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
	@Column(name="status")
	private String status;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="booking_details",
			joinColumns=@JoinColumn(name="booking_id"),
			inverseJoinColumns=@JoinColumn(name="passenger_id"))
	private List<Passenger> passengers;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="flight_id")
	private Flight flight;
	public BookingRecord()
	{
		
	}
	public BookingRecord(Integer bookingId, Date bookingDate, String destination, Double fare, Date flightDate,
			String flightNumber, Date flightTime, String origin, String status) {
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.destination = destination;
		this.fare = fare;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
		this.status = status;
	}
	
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	@Override
	public String toString() {
		return "BookingRecord [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", destination=" + destination
				+ ", fare=" + fare + ", flightDate=" + flightDate + ", flightNumber=" + flightNumber + ", flightTime="
				+ flightTime + ", origin=" + origin + ", status=" + status + "]";
	}
	public void addPassenger(Passenger passenger)
	{
		if(passengers == null)
		{
			passengers = new ArrayList<>();
		}
		passengers.add(passenger);
		
		
	}
	
	
	
}
