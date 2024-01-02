package com.kashif.drivermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.drivermanagement.model.Ride;

public interface RideRepository extends JpaRepository<Ride, Long> {
    
}
