package com.example.Springcurdliquibase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Springcurdliquibase.service.Userservice;
import com.example.Springcurdliquibase.service.UserserviceImpl;
import com.example.Springcurdliquibase.user.User;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("v1/api/users")
public class UserController {

	private  Userservice userservice ;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User create=userservice.createuser(user);
		return new ResponseEntity<User>(create, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping({"id"})
	public ResponseEntity<User> getUserbyId(@PathVariable("id") Long userId){
		User getId=userservice.getbyID(userId);
		return new ResponseEntity<User>(getId, HttpStatus.OK);
		
	}
	
	@PutMapping({"id"})
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@RequestBody User user){
		User updateId=userservice.updateUser(user);
		return new ResponseEntity<User>(updateId,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
		userservice.deletbyUserId(userId);
		return new ResponseEntity<>("User Successfully ",HttpStatus.OK);
		
	}
	
}
