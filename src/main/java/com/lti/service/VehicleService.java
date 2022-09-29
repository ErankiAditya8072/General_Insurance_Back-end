package com.lti.service;

import com.lti.entity.Insurance;
import com.lti.entity.Vehicle_Insurance;
import com.lti.exception.NoInsuranceFoundException;

public interface VehicleService {

	
	public Vehicle_Insurance addVehicle(Vehicle_Insurance v,Long pno) throws NoInsuranceFoundException;
	public Vehicle_Insurance getVehicleByPolicyNo(Long pno) throws NoInsuranceFoundException;

}
