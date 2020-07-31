package com.example.SampleSpringBootMvc.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SampleSpringBootMvc.dao.FlightRepository;
import com.example.SampleSpringBootMvc.dao.PassengerRepository;
import com.example.SampleSpringBootMvc.dateUtils.DateUtils;
import com.example.SampleSpringBootMvc.entity.Flight;
import com.example.SampleSpringBootMvc.entity.Passenger;

@Controller
public class FlightController {
@Autowired
private FlightRepository flightRepository;

@RequestMapping("/fetchFlights")
public String fetchFlights(@ModelAttribute("flight") Flight flight,HttpServletRequest request,Model model,@RequestParam("date") String flightDate) throws ParseException
{
	String origin = flight.getOrigin();
	String destination = flight.getDestination();
	Date date = DateUtils.parseDate(flightDate);
	List<Flight> flightData = flightRepository.findByOriginAndDestinationAndFlightDate(origin, destination, date);
	HttpSession session = request.getSession(false);
	String username = (String)session.getAttribute("username");
    model.addAttribute("flight", flightData);
	return "flightData";
}
}
