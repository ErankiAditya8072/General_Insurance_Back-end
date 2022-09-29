package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Claim_Insurance;

@Repository
public interface ClaimDao extends JpaRepository<Claim_Insurance,Long> {
      
}
