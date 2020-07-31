package com.example.SampleSpringBootMvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SampleSpringBootMvc.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

	
}
