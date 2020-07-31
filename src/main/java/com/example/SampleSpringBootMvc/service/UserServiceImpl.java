package com.example.SampleSpringBootMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SampleSpringBootMvc.dao.UserRepository;
import com.example.SampleSpringBootMvc.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
     
		userRepository.save(user);
	}

	@Override
	public List<User> validateUser(String username, String password) {
		 return userRepository.findByUserNameAndPassword(username, password);
		 }

	@Override
	public User getUser(String username) {
		return userRepository.findByUserName(username);
	}

	

	
	
}
