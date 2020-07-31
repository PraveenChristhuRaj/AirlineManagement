package com.example.SampleSpringBootMvc.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SampleSpringBootMvc.dateUtils.DateTimeUtils;
import com.example.SampleSpringBootMvc.dateUtils.DateUtils;
import com.example.SampleSpringBootMvc.dateUtils.TimeUtils;
import com.example.SampleSpringBootMvc.entity.BookingRecord;
import com.example.SampleSpringBootMvc.entity.Flight;
import com.example.SampleSpringBootMvc.entity.Passenger;
import com.example.SampleSpringBootMvc.entity.User;
import com.example.SampleSpringBootMvc.service.BookingRecordService;
import com.example.SampleSpringBootMvc.service.FlightService;
import com.example.SampleSpringBootMvc.service.PassengerService;
import com.example.SampleSpringBootMvc.service.UserService;

@Controller
public class BookRecordController {

@Autowired
private FlightService flightService;
@Autowired
private BookingRecordService bookingRecordService;
@Autowired
private PassengerService passengerService;
@Autowired
private UserService userService;
@RequestMapping("/bookTicket")
public String bookTicket(@RequestParam("flightId") int flightId,Model model)
{
	Flight flight = flightService.getFlight(flightId);
	BookingRecord bookingRecord = new BookingRecord();
	model.addAttribute("flight", flight);
	model.addAttribute("bookingRecord",bookingRecord);
	return "bookTicket";
}
@RequestMapping("/ticketBook")
public String ticketBook(@ModelAttribute("bookingRecord") BookingRecord bookingRecord,HttpServletRequest request,
		@RequestParam("date") String date,@RequestParam("time") String time,@RequestParam("flightId") Integer flightId,Model model) throws ParseException
{
	HttpSession session = request.getSession(false);
	String username = (String)session.getAttribute("username");
	Date bookingDate = DateTimeUtils.parseDate();
	Date flightDate = DateUtils.parseDate(date);
	Date flightTime = TimeUtils.parseDate(time);
	Random random = new Random();
	Integer id = random.nextInt(1000);
	String status = "Pending";
	bookingRecord.setBookingDate(bookingDate);
	bookingRecord.setBookingId(id);
	bookingRecord.setStatus(status);
	bookingRecord.setFlightDate(flightDate);
	bookingRecord.setFlightTime(flightTime);
	Flight flight = flightService.getFlight(flightId);
	User user = userService.getUser(username);
	bookingRecord.setFlight(flight);
	bookingRecord.setUser(user);
	bookingRecordService.save(bookingRecord);
	model.addAttribute("bookingRecord",bookingRecord);
	model.addAttribute("passenger",new Passenger());
	return "passengerForm";
}
@RequestMapping("/bookPassenger")
public String bookPassenger(@ModelAttribute("passenger") Passenger passenger,Model model,@RequestParam("bookingId") Integer bookingId)
{
	BookingRecord bookingRecord = bookingRecordService.getBookingRecord(bookingId);
	Random random = new Random();
	Integer id = random.nextInt(1000);
	passenger.setPassengerId(id);
	passenger.setBookingRecord(bookingRecord);
	passenger.addbooking(bookingRecord);
    passengerService.save(passenger);
    model.addAttribute("bookingRecord",bookingRecord);
    model.addAttribute("passenger",passenger);
	return "bookingConfirmation";
}
@RequestMapping("/seatConfirm")
public String seatConfirm(@RequestParam("bookingId") Integer bookingId,Model model)
{
	BookingRecord bookingRecord = bookingRecordService.getBookingRecord(bookingId);
	Integer flightId = bookingRecord.getFlight().getId();
	Flight flight = flightService.getFlight(flightId);
	int count = bookingRecord.getPassengers().size();
    flight.getInventory().setCount(flight.getInventory().getCount()-count);
    bookingRecord.setStatus("Confirmed");
    bookingRecordService.save(bookingRecord);
    flightService.save(flight);
    model.addAttribute(bookingRecord);
	return "seatConfirmation";
}

@RequestMapping("/pendingBooking")
public String getPendingBooking(HttpServletRequest request,Model model)
{
	HttpSession session = request.getSession(false);
	String username = (String)session.getAttribute("username");
	User user = userService.getUser(username);	
	Integer userId = user.getUserId();
	List<BookingRecord> bookingRecord = bookingRecordService.findByUserId(userId);	
	model.addAttribute("bookingRecord", bookingRecord);
	return "pendingBooking";
    
}

}
