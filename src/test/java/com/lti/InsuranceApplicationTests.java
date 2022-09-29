package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.ClaimDao;
import com.lti.dao.Insurancedao;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.entity.Vehicle_Insurance;
import com.lti.exception.NoInsuranceFoundException;
import com.lti.exception.NoSuchClaimFound;
import com.lti.exception.NoSuchUserFoundException;
import com.lti.service.AdminServiceImpl;
import com.lti.service.ClaimServiceImpl;
import com.lti.service.InsuranceServiceImpl;
import com.lti.service.UserServiceImpl;


@SpringBootTest
class InsuranceApplicationTests {
 
	@Autowired
	private UserServiceImpl user_service;
	
	@Autowired
	private InsuranceServiceImpl i_service;
	
	@Autowired
	private AdminServiceImpl a_service;
	
	@Autowired 
	private ClaimDao claim_repo;
	
	@Autowired
	private ClaimServiceImpl claimService;
	
	@Autowired
	private Insurancedao ins_repo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void CreateUser()
	{
		User user =new User();
		user.setName("Dhruv");
		user.setEmail("dhruv@email.com");
		user.setAddress("mumbai");
		user.setDob("2000-08-27");
		user.setPassword("dhruv");
		user.setContact(93228095098L);
		
		User u = user_service.addUser(user);
		
		assertEquals("dhruv@email.com",user.getEmail());
	}
    
	@Test
	public void Login() throws NoSuchUserFoundException
	{
		User user  = new User();
		user.setEmail("dhruv@email.com");
		user.setPassword("dhruv");
		
		User u = user_service.CheckUser(user);
		
		assertEquals("dhruv@email.com",u.getEmail());
		assertEquals("dhruv",u.getPassword());
	}
	
	@Test
	public void addInusrance() throws NoSuchUserFoundException
	{
		User user =new User();
		user.setName("Aditya");
		user.setEmail("aditya@email.com");
		user.setAddress("mumbai");
		user.setDob("2002-08-27");
		user.setPassword("aditya");
		user.setContact(93228095098L);
		
		Insurance ins  = new Insurance();
		ins.setPremium_amount(3000l);
		ins.setDuration(3);
		ins.setInsurance_value(23000l);
		ins.setStart_date("2000-12-27");
		
		
		ins.setUser(user);
		
		Vehicle_Insurance vehicle = new Vehicle_Insurance();
		vehicle.setChasis_no("232as2qsdf");
		vehicle.setEngine_no("23asd98uljjk23");
		vehicle.setLicense_no("MHa238982323");
		vehicle.setManufacturer("honda");
		vehicle.setModel("v14");
		vehicle.setPurchase_date("2012-06-22");
		vehicle.setReg_no("MH06AZ3223");
		
		ins.setVehicleIns(vehicle);
		
		user_service.addUser(user);
		user.getInsurance().add(ins);
		Insurance i = i_service.addInsurance(ins);
		
		assertEquals("aditya@email.com",i.getUser().getEmail());
		assertEquals("MH06AZ3223",i.getVehicleIns().getReg_no());
		
	}
	
	@Test
	public void AdminTest() {
		
		Admin a=new Admin();
		a.setAdmin_id(1011);
		a.setPassword("admin");
		
		Admin a1=a_service.addAdmin(a);
		
		assertEquals("admin",a1.getPassword());
		
	}
	
	
	@Test
	public void Claimed() throws NoInsuranceFoundException
	{
		
		User user =new User();
		user.setName("Anand");
		user.setEmail("Anand@email.com");
		user.setAddress("chennai");
		user.setDob("2002-08-27");
		user.setPassword("anand");
		user.setContact(93228095098L);
		
		Insurance ins  = new Insurance();
		ins.setPremium_amount(5000l);
		ins.setDuration(2);
		ins.setInsurance_value(23000l);
		ins.setStart_date("2000-12-27");
		
		
		ins.setUser(user);
		
		Vehicle_Insurance vehicle = new Vehicle_Insurance();
		vehicle.setChasis_no("232as2qsdf");
		vehicle.setEngine_no("23asd98uljjk23");
		vehicle.setLicense_no("MHa238982323");
		vehicle.setManufacturer("honda");
		vehicle.setModel("v14");
		vehicle.setPurchase_date("2012-06-22");
		vehicle.setReg_no("MH06AZ3823");
		
		ins.setVehicleIns(vehicle);
		
		user_service.addUser(user);
		user.getInsurance().add(ins);
		
		
		
		Claim_Insurance claim = new Claim_Insurance();
		claim.setReason("theft");
		claim.setClaim_date("2012-08-22");
		
		ins.getClaimIns().add(claim);
		
		Insurance i = i_service.addInsurance(ins);
		
		assertEquals("theft",i.getClaimIns().get(0).getReason());
	}
	
	
	
	
}
