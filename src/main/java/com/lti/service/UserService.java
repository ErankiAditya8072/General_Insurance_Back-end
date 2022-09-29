package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchUserFoundException;

public interface UserService {

	public User CheckUser(User user) throws NoSuchUserFoundException;
	public User addUser(User user);
	public User getUserByMail(String email) throws NoSuchUserFoundException;
	public User setInsurance(Insurance ins, String email) throws NoSuchUserFoundException;
	public Set<Insurance> getAllInsurance(String email) throws NoSuchUserFoundException, NoInsuranceFoundException;
	public User changePassword(User user) throws NoSuchUserFoundException;
}
