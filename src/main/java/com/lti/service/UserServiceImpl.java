package com.lti.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dao.Insurancedao;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchUserFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao repo;
	
	@Autowired
	private Insurancedao ins_repo;
	
	@Override
	public User addUser(User user) {
		
	   return repo.save(user);
	}

	@Override
	public User CheckUser(User user) throws NoSuchUserFoundException
	{
		
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println(email +" "+password);
		if(repo.existsById(email))
		{
			User u = this.getUserByMail(email);
			if(u.getPassword().equals(password))
			{
				return u;
			}
		}
		return null;
	}
	@Override
	public User getUserByMail(String email) throws NoSuchUserFoundException {
		
		Optional<User> sFind= repo.findById(email);
		if(repo.existsById(email)) {
			System.out.println("User sent");
			return sFind.get();
		}
		else {
			throw new NoSuchUserFoundException("No Such User Found Exception");
		}
		
		
	}
	
	@Override
	public User setInsurance(Insurance ins,String email) throws NoSuchUserFoundException
	{
	  
	    User u = this.getUserByMail(email);
	    u.getInsurance().add(ins);
	    ins.setUser(u);
	    ins_repo.save(ins);
	    return repo.save(u);
	   
	}
	
	
	@Override
	public Set<Insurance> getAllInsurance(String email) throws NoSuchUserFoundException , NoInsuranceFoundException {
		
		return this.getUserByMail(email).getInsurance();
	}

	@Override
	public User changePassword(User user) throws NoSuchUserFoundException {
		
		  User u = this.getUserByMail(user.getEmail());
		  u.setPassword(user.getPassword());
		  
		  return repo.save(u);
	}
	
}
