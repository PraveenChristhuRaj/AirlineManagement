package com.example.SampleSpringBootMvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SampleSpringBootMvc.entity.Flight;
import com.example.SampleSpringBootMvc.service.FlightService;

@Controller
public class HelloController {

	@Autowired
	private FlightService flightService;
	@RequestMapping("/list")
	public String hello(Model model)
	{
		List<Flight> flight = flightService.getFlights();
		model.addAttribute("flight", flight);
		return "listFlight";
	}
}
