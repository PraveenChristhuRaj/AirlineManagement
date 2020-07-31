package com.example.SampleSpringBootMvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fare")
public class Fare {

	@Id
	@Column(name="fare_id")
	private Integer fareId;
	@Column(name="currency")
	private String currency;
	@Column(name="fare")
	private double fare;
    public Fare()
    {
    	
    }
    
	public Fare(Integer fareId, String currency, double fare) {
		this.fareId = fareId;
		this.currency = currency;
		this.fare = fare;
	}

	public Integer getFareId() {
		return fareId;
	}
	public void setFareId(Integer fareId) {
		this.fareId = fareId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Fare [fareId=" + fareId + ", currency=" + currency + ", fare=" + fare + "]";
	}
	
    
}
