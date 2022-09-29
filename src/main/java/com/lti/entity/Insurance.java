package com.lti.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Insurance")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "policy_no")
public class Insurance {

	@Id
	@SequenceGenerator(name="policy_no",initialValue = 11111,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_no")
    private Long policy_no;
	
	private Long premium_amount;
	private Long insurance_value;
	private Date start_date;


	private int duration;
	private String claimed_status = "Not Claimed";
    private Long total_claimed_amount = 0L;	

	@ManyToOne
	@JoinColumn(name = "U_FK")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "V_FK")
	private Vehicle_Insurance vehicleIns;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Claim_FK")
	private List<Claim_Insurance>  claimIns = new ArrayList<Claim_Insurance>();

	
	public List<Claim_Insurance> getClaimIns() {
		return claimIns;
	}

	public void setClaimIns(List<Claim_Insurance> claimIns) {
		this.claimIns = claimIns;
	}

	public Long getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(Long policy_no) {
		this.policy_no = policy_no;
	}

	public Long getPremium_amount() {
		return premium_amount;
	}

	public void setPremium_amount(Long premium_amount) {
		this.premium_amount = premium_amount;
	}
	public Long getInsurance_value() {
		return insurance_value;
	}

	public void setInsurance_value(Long insurance_value) {
		this.insurance_value = insurance_value;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = Date.valueOf(start_date);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getClaimed_status() {
		return claimed_status;
	}

	public void setClaimed_status(String claimed_status) {
		this.claimed_status = claimed_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle_Insurance getVehicleIns() {
		return vehicleIns;
	}

	public void setVehicleIns(Vehicle_Insurance vehicleIns) {
		this.vehicleIns = vehicleIns;
	}

	public Long getTotal_claimed_amount() {
		return total_claimed_amount;
	}

	public void setTotal_claimed_amount(Long total_claimed_amount) {
		this.total_claimed_amount = total_claimed_amount;
	}

	
	@Override
	public String toString() {
		return "Insurance [policy_no=" + policy_no + ", premium_amount=" + premium_amount + ", insurance_value="
				+ insurance_value + ", start_date=" + start_date + ", duration=" + duration + ", claimed_status="
				+ claimed_status + ", total_claimed_amount=" + total_claimed_amount + ", user=" + user + ", vehicleIns="
				+ vehicleIns + ", claimIns=" + claimIns + "]";
	}
	
	
	
}
