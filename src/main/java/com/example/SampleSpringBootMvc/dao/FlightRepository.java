package com.example.SampleSpringBootMvc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SampleSpringBootMvc.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	public List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination,Date date);
}
