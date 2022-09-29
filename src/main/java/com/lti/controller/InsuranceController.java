package com.lti.controller;

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
import com.lti.service.InsuranceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InsuranceController {

	@Autowired
	private InsuranceService iService;
	
	
	
	@PostMapping("/insurance")
	public Insurance createInsurance(@RequestBody Insurance ins)
	{
		return iService.addInsurance(ins);
	}
	
	@GetMapping("/insurance/{pno}")
	public Insurance getByPolicyNo(@PathVariable("pno") Long pno) throws NoInsuranceFoundException
	{
		return iService.getByPolicyNo(pno);
	}
	
//	@GetMapping("/insurance/{pno}")
//	public User getByPolicyNo(@PathVariable("pno") Long pno) throws NoInsuranceFoundException, NoSuchUserFoundException
//	{
//		return iService.getUserByPolicyNo(pno);
//	}
	
	@PostMapping("/insurance/renew")
	public Insurance renewInsurance(@RequestBody Insurance ins) throws NoInsuranceFoundException
	{
		return iService.renewInsurance(ins);
	}

	
}
