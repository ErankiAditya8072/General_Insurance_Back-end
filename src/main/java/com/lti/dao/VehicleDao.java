package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Vehicle_Insurance;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle_Insurance, Long> {

}
