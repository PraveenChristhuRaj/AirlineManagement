package com.example.SampleSpringBootMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SampleSpringBootMvc.dao.PassengerRepository;
import com.example.SampleSpringBootMvc.entity.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public void save(Passenger passenger) {
       passengerRepository.save(passenger);		
	}
	

	
}
