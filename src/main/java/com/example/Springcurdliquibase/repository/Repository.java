package com.example.Springcurdliquibase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springcurdliquibase.user.User;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Long>  {
	
	

}
