package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.Insurancedao;
import com.lti.dao.VehicleDao;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle_Insurance;
import com.lti.exception.NoInsuranceFoundException;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDao v_repo;
	
	@Autowired
	private InsuranceServiceImpl ins_service;
	
	@Autowired
	private Insurancedao ins_dao;
	
	@Override
	public Vehicle_Insurance addVehicle(Vehicle_Insurance v,Long pno) throws NoInsuranceFoundException {
		
		Insurance ins = ins_service.getByPolicyNo(pno);
		ins.setVehicleIns(v);
		ins_dao.save(ins);
		return v_repo.save(v);
		
		
	}

	@Override
	public Vehicle_Insurance getVehicleByPolicyNo(Long pno) throws NoInsuranceFoundException {
		Insurance ins = ins_service.getByPolicyNo(pno);
		return ins.getVehicleIns();
		
	}

}
