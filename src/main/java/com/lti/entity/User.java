package com.lti.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "User_Table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                  property = "email")
public class User {

	@Id
	private String email;
	
	@JsonIgnore
	private Long user_id;
	
	private String name;
	private Long contact;
	private Date dob;
	private String address;
	private String password;
	
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
	private Set<Insurance> insurance = new HashSet<Insurance>();
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public Set<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Set<Insurance> insurance) {
		this.insurance = insurance;
	}

	public void setDob(String dob) {
		this.dob = Date.valueOf(dob);
	}

    
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", user_id=" + user_id + ", name=" + name + ", contact=" + contact + ", dob="
				+ dob + ", address=" + address + ", password=" + password +"]";
	}



	
	
	
	
	
}

