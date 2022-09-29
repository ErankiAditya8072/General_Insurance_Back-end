package com.lti.service;

import java.util.List;

import com.lti.entity.Claim_Insurance;
import com.lti.exception.NoInsuranceFoundException;

public interface ClaimService {

	public List<Claim_Insurance> addClaim(Claim_Insurance claim,Long policy_no) throws NoInsuranceFoundException;
}
