package com.example.Springcurdliquibase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Springcurdliquibase.repository.Repository;
import com.example.Springcurdliquibase.user.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserserviceImpl implements Userservice{
	
	
private	Repository repository;
	
	@Override
	public User createuser(User User) {
		
		return repository.save(User);
	}

	@Override
	public void deletbyUserId(Long userId) {
		 repository.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user) {
	
		//return repository.saveAndFlush(user);-----> one way
		
		User existingUser=repository.findById(user.getId()).get();
	
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setEmail(user.getEmail());
		
		User updatedUser=repository.save(existingUser);
		
		return updatedUser;
	}

	@Override
	public User getbyID(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> getUser=repository.findById(userId);
		
		return getUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
		
	}



}
