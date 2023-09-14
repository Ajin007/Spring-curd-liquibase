package com.example.Springcurdliquibase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Springcurdliquibase.user.User;


public interface Userservice {
	
	User createuser(User User);
	void deletbyUserId(Long userId);
	User updateUser(User user);
	User getbyID(Long userId);
	List<User> getAllUsers();
	
	

}
