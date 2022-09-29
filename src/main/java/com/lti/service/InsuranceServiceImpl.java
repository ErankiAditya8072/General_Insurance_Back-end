package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.Insurancedao;
import com.lti.dao.UserDao;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchUserFoundException;

@Service
public class InsuranceServiceImpl implements InsuranceService{
      
	@Autowired
	private Insurancedao insdao;
	
	@Autowired
	private UserServiceImpl u_service;

	@Override
	public Insurance addInsurance(Insurance ins) {
		
		return insdao.save(ins);
	}

	@Override
	public Insurance getByPolicyNo(Long pno) throws NoInsuranceFoundException{
	
		Optional<Insurance> sfind = insdao.findById(pno);
		if(insdao.existsById(pno)) {
			System.out.println(sfind.get());
			return sfind.get();
		}
		else 
		{
			throw new NoInsuranceFoundException("NO such Policy Number Found ");
		}
	}

	
	@Override
	public User getUserByPolicyNo(Long pno) throws NoSuchUserFoundException, NoInsuranceFoundException {
		
	      return getByPolicyNo(pno).getUser();
	  
	    
		
	}

	@Override
	public Insurance renewInsurance(Insurance ins) throws NoInsuranceFoundException {
		
		Insurance i = this.getByPolicyNo(ins.getPolicy_no());
		i.setDuration(ins.getDuration());
		i.setStart_date(ins.getStart_date().toString());
		i.setPremium_amount(ins.getPremium_amount());
		i.setInsurance_value(ins.getInsurance_value());
		i.setClaimed_status("Not Claimed");
		i.setTotal_claimed_amount(0L);
		
		return insdao.save(i);
	 
	}

	
}
