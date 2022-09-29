package com.lti.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Claim_Insurance")
public class Claim_Insurance {

	@Id
	@SequenceGenerator(name="claim_id",initialValue = 52325,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claim_id")
    private Long claim_id;
	private Date claim_date;
	private String claim_status = "pending";
	private long amount=0;
	private String reason;
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Long getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(Long claim_id) {
		this.claim_id = claim_id;
	}
	public Date getClaim_date() {
		return claim_date;
	}
	public void setClaim_date(String claim_date) {
		this.claim_date = Date.valueOf(claim_date);
	}

	public String getClaim_status() {
		return claim_status;
	}
	public void setClaim_status(String claim_status) {
		this.claim_status = claim_status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
