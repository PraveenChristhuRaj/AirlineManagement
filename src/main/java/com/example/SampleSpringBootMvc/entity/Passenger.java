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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="passenger")
public class Passenger {
    
	@Id
	@Column(name="passenger_id")
	private Integer passengerId;
	@Column(name="email_address")
	private String emailAddress;
	@Column(name="first_name")
	private String firstName;
	@Column(name="gender")
	private String gender;
	@Column(name="last_name")
	private String lastName;
	@Column(name="mobile_number")
	private long mobileNumber;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="booking_details",
			joinColumns=@JoinColumn(name="passenger_id"),
			inverseJoinColumns=@JoinColumn(name="booking_id"))
	private List<BookingRecord> bookingRecords;
	@OneToOne
	@JoinColumn(name="booking_id")
	private BookingRecord bookingRecord;
	public Passenger()
	{
		
	}

	
	


	public Passenger(Integer passengerId, String emailAddress, String firstName, String gender,
			String lastName, long mobileNumber) {
		this.passengerId = passengerId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}


	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
    public BookingRecord getBookingRecord() {
		return bookingRecord;
	}





	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	}





	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", emailAddress=" + emailAddress + ", firstName=" + firstName
				+ ", gender=" + gender + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}


	


	
	public List<BookingRecord> getBookingRecords() {
		return bookingRecords;
	}





	public void setBookingRecords(List<BookingRecord> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}


public void addbooking(BookingRecord bookingRecord)
	{
		if(bookingRecords == null)
		{
			bookingRecords = new ArrayList<>();
		}
		bookingRecords.add(bookingRecord);
		
		
	}
	
}
