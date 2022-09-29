package com.lti.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.Claim_Insurance;
import com.lti.entity.Insurance;

@Repository
public interface Insurancedao extends JpaRepository<Insurance,Long> {

	 public Insurance findByClaimIns(Claim_Insurance claimIns);
}
