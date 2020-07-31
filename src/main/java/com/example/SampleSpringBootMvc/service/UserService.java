package com.example.SampleSpringBootMvc.service;

import java.util.List;

import com.example.SampleSpringBootMvc.entity.User;

public interface UserService {

	public void save(User user);
	public List<User> validateUser(String username,String password);
    public User getUser(String username);
	
}
