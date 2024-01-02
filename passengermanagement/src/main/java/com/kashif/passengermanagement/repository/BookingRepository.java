package com.kashif.passengermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.passengermanagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findByRideId(int rideId);
}
