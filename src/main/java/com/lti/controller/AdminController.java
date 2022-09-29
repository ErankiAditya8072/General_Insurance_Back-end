package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Admin;
import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;
import com.lti.entity.User;
import com.lti.exception.NoSuchAdminFound;
import com.lti.exception.NoSuchClaimFound;
import com.lti.service.AdminServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin)
	{
		return adminService.addAdmin(admin);
	}
	
	
	@PostMapping("/admin/claim")
	public Insurance  changeClaimStatus(@RequestBody Claim_Insurance claim_ins) throws NoSuchClaimFound
	{
		return adminService.changeClaimStatus(claim_ins);
	}
//    
	
	@PostMapping("/admin/login")
	public Admin getAdmin(@RequestBody Admin admin) throws NoSuchAdminFound
	{
		return adminService.getAdmin(admin);
	}
	
	@GetMapping("/admin/users")
	public List<User> getAllUsers()
	{
		return adminService.getAllUsers();
	}
	
	@GetMapping("/admin/insurances")
	public List<Insurance> getAllInsurance()
	{
		return adminService.getAllInsurance();
	}
	
	
	@GetMapping("/admin/claims")
	public List<Claim_Insurance> getAllClaims()
	{
		return adminService.getAllClaims();
	}
}
