package com.example.SampleSpringBootMvc.service;

import java.util.Date;
import java.util.List;

import com.example.SampleSpringBootMvc.entity.Flight;

public interface FlightService {

	public List<Flight> getFlights();
	public List<Flight> fetchFlights(String origin,String destination,Date date);
	public Flight getFlight(Integer flightId);
	public void save(Flight flight);
}
