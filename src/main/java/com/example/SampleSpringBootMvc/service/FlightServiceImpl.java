package com.example.SampleSpringBootMvc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SampleSpringBootMvc.dao.FlightRepository;
import com.example.SampleSpringBootMvc.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public List<Flight> getFlights() {
		List<Flight> flight=flightRepository.findAll();
		return flight;
	}

	@Override
	public List<Flight> fetchFlights(String origin,String destination,Date date) {
		return flightRepository.findByOriginAndDestinationAndFlightDate(origin, destination, date);
	}

	@Override
	public Flight getFlight(Integer flightId) {

		Optional<Flight> result = flightRepository.findById(flightId);
		Flight flight = null;
		if(result.isPresent())
		{
             flight = result.get();			
		}
		return flight;

	}

	@Override
	public void save(Flight flight) {
        flightRepository.save(flight);
         		
	}

	
}
