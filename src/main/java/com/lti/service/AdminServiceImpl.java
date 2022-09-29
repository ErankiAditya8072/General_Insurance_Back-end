package com.lti.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.ClaimDao;
import com.lti.dao.Insurancedao;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoSuchAdminFound;
import com.lti.exception.NoSuchClaimFound;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao admin_repo;
	
	@Autowired 
	private UserDao user_repo;
	
	@Autowired
	private Insurancedao ins_repo;
	
	@Autowired
	private ClaimDao claim_repo;
	
	@Override
	public Admin addAdmin(Admin admin) {
		return admin_repo.save(admin);
	}
	
	public Insurance setClaimedStatus(Insurance ins)
	{
		if(ins.getInsurance_value() - ins.getTotal_claimed_amount() > 0)
		{
			ins.setClaimed_status("Partially Claimed");
		}
		else {
			ins.setClaimed_status("Fully Claimed");
		}
		return ins;
	}
	
	@Override
	public Insurance changeClaimStatus(Claim_Insurance claim_ins) throws NoSuchClaimFound
	{
		Optional<Claim_Insurance> sFind = claim_repo.findById(claim_ins.getClaim_id());
		if(claim_repo.existsById(claim_ins.getClaim_id()))
		{
			Claim_Insurance claim = sFind.get();
	        claim.setClaim_status(claim_ins.getClaim_status());
	        claim.setAmount(claim_ins.getAmount());
	        
	        Insurance ins = ins_repo.findByClaimIns(claim);
	        
	        ins.setTotal_claimed_amount(ins.getTotal_claimed_amount()+ claim.getAmount());
	        
	        Insurance ins_changed = setClaimedStatus(ins);
	  
	        return ins_repo.save(ins_changed);
	        
	        
		}
		else {
			throw new NoSuchClaimFound("No such Claim Found");
		}
	}

	@Override
	public Admin getAdmin(Admin admin) throws NoSuchAdminFound {
		
		Optional<Admin> sFind = admin_repo.findById(admin.getAdmin_id());
		if(admin_repo.existsById(admin.getAdmin_id()))
		{
			Admin ad =  sFind.get();
			if(ad.getPassword().equals(admin.getPassword()))
			{
				return ad;
			}
			else {
				return null;
			}
		}
		else {
			throw new NoSuchAdminFound("No such Admin found");
		}
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> sFind = user_repo.findAll();
		
		return sFind;
		
	}

	@Override
	public List<Insurance> getAllInsurance() {
		List<Insurance> sFind = ins_repo.findAll();
		
		return sFind;
	}

	@Override
	public List<Claim_Insurance> getAllClaims() {
		
		List<Claim_Insurance> sFind = claim_repo.findAll();
		
		return sFind;
	}

}
