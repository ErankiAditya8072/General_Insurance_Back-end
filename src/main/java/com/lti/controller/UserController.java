package com.lti.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchUserFoundException;
import com.lti.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService u_service;
	
	
	@PostMapping("/users/login")
	public User login(@RequestBody User user) throws NoSuchUserFoundException
	{
		return u_service.CheckUser(user);
	}
	
    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
    	return u_service.addUser(user);
    }
    
    
    @GetMapping("/users/{mail}")
    public User getUserByMail(@PathVariable("mail") String mail) throws NoSuchUserFoundException
    {
    	
    	return u_service.getUserByMail(mail);
    }
    
    @PostMapping("/users/forgotpassword")
    public User changePassword(@RequestBody User user) throws NoSuchUserFoundException
    {
    	return u_service.changePassword(user);
    }
    
    @PostMapping("/users/{email}")
    public User createInsurance(@PathVariable("email") String email,@RequestBody Insurance ins) throws NoSuchUserFoundException
    {
        return u_service.setInsurance(ins, email);
    }
    
    @GetMapping("/users/insurance/{email}")
    public Set<Insurance> getAllInsurance(@PathVariable("email") String email) throws NoSuchUserFoundException, NoInsuranceFoundException
    {
    	return u_service.getAllInsurance(email);
    }
    
    
    
    
    
}
