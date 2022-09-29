package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Claim_Insurance;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.service.ClaimServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClaimController {

	@Autowired
	private ClaimServiceImpl claimService;
	
	@PostMapping("insurance/claim/{pno}")
	public List<Claim_Insurance> addClaim(@RequestBody Claim_Insurance claim,@PathVariable("pno") Long pno) throws NoInsuranceFoundException
	{
		return claimService.addClaim(claim, pno);
	}
}
