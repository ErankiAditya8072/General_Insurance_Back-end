package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ClaimDao;
import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;
import com.lti.exception.NoInsuranceFoundException;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimDao c_repo;
	
	@Autowired
	private InsuranceServiceImpl ins_service;
	
	@Override
	public List<Claim_Insurance> addClaim(Claim_Insurance claim,Long policy_no) throws NoInsuranceFoundException {
		Insurance ins = ins_service.getByPolicyNo(policy_no);
		ins.getClaimIns().add(claim);
		ins_service.addInsurance(ins);
		
		return  ins.getClaimIns();
	   
	}

}
