package com.example.SampleSpringBootMvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SampleSpringBootMvc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	public List<User> findByUserNameAndPassword(String username,String password);
	public User findByUserName(String username);

}
