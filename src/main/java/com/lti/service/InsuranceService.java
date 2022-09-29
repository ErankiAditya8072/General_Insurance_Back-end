package com.lti.service;

import java.util.List;

import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchUserFoundException;

public interface InsuranceService {
     
	public Insurance addInsurance(Insurance ins);
	public Insurance getByPolicyNo(Long pno) throws NoInsuranceFoundException;
	public User getUserByPolicyNo(Long pno) throws NoSuchUserFoundException, NoInsuranceFoundException;
	public Insurance renewInsurance(Insurance ins) throws NoInsuranceFoundException;

}