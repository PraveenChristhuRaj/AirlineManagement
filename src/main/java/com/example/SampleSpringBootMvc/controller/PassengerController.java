package com.example.SampleSpringBootMvc.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SampleSpringBootMvc.entity.Flight;
import com.example.SampleSpringBootMvc.entity.User;
import com.example.SampleSpringBootMvc.service.FlightService;
import com.example.SampleSpringBootMvc.service.PassengerService;
import com.example.SampleSpringBootMvc.service.UserService;

@Controller
public class PassengerController {
    @Autowired
	private PassengerService passengerService;
    @Autowired
    private UserService userService;
    @Autowired 
    private FlightService flightService;
    @RequestMapping("/")
	public String loginPassenger(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("flight",new Flight());
		return "loginPassengerPage";
	}
	@RequestMapping("/showUserForm")
	public String showPassengerForm(Model model)
	{
		model.addAttribute("user", new User());
		return "userForm";
	}
	@RequestMapping("/processUserForm")
	public String processPassengerForm(@ModelAttribute("user") User user)
	{
		 Random random = new Random();
		 int id = random.nextInt(1000);
		 user.setUserId(id);
	     userService.save(user);
	     return "userConfirm";
	}
	
	@RequestMapping("/validateLogin")
	public String loginValidate(@ModelAttribute("user") User user,Model model,HttpSession session)
	{
		String username=user.getUserName();
		String password = user.getPassword();
	    List<User> userValidate = userService.validateUser(username, password);
	    if(userValidate.isEmpty())
	    {
	    	  String message = "Username or password is incorrect";
	    	  model.addAttribute("message",message);
	    	  return "loginPassengerPage";
	    }
	    else
	    {
	    	List<Flight> flight = flightService.getFlights();
	    	model.addAttribute("flight", flight);
	    	session.setAttribute("username",username);
            return "passengerPage";
	    }
	}
	@RequestMapping("/applicationLogout")
	public String logout(HttpServletRequest request,Model model)
	{
             HttpSession session = request.getSession(false);
             session.removeAttribute("username");
             model.addAttribute("user", new User());
     		model.addAttribute("flight",new Flight());
             return "loginPassengerPage";
           
	}
	@RequestMapping("/homePage")
	public String homePage(Model model)
	{
		List<Flight> flight = flightService.getFlights();
    	model.addAttribute("flight", flight);
    	return "passengerPage";
		
	}
}
