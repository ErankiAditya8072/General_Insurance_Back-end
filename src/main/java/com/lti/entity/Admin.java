package com.lti.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
     
	@Id
	private long admin_id;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<User> listOfUsers = new HashSet<User>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Insurance> listOfIns = new HashSet<Insurance>();
	
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Claim_Insurance> listOfClaims = new HashSet<Claim_Insurance>();
    
	public long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
