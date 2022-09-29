package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Insurance;
import com.lti.entity.Vehicle_Insurance;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.service.VehicleServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehicleController {
  
	@Autowired
	private VehicleServiceImpl v_service;
	
	@PostMapping("/insurance/vehicle/{pno}")
	public Vehicle_Insurance addVehicle(@RequestBody Vehicle_Insurance vehicle,@PathVariable("pno") Long pno) throws NoInsuranceFoundException
	{
		return v_service.addVehicle(vehicle, pno);
	}
	
	@GetMapping("/insurance/vehicle/{pno}")
	public Vehicle_Insurance getVehicle(@PathVariable("pno") Long pno) throws NoInsuranceFoundException
	{
		return v_service.getVehicleByPolicyNo(pno);
	}
}
