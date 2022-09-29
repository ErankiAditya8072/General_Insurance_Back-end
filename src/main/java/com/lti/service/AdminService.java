package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.entity.Admin;
import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoSuchAdminFound;
import com.lti.exception.NoSuchClaimFound;

public interface AdminService {
 
	public Admin addAdmin(Admin admin);
	public Admin getAdmin(Admin admin) throws NoSuchAdminFound;
	public List<User> getAllUsers();
	public List<Insurance> getAllInsurance();
	public List<Claim_Insurance> getAllClaims();
	public Insurance changeClaimStatus(Claim_Insurance claim_ins) throws NoSuchClaimFound;
}
