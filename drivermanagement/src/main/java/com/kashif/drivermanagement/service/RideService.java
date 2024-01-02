package com.kashif.drivermanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.kashif.drivermanagement.dto.RideRequest;
import com.kashif.drivermanagement.dto.RideResponse;
import com.kashif.drivermanagement.model.Ride;
import com.kashif.drivermanagement.repository.RideRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class RideService {
    private final RideRepository rideRepository;

    public void createRide(RideRequest rideRequest) {
        Ride ride = new Ride();
        ride.setPickup(rideRequest.getPickup());
        ride.setDestination(rideRequest.getDestination());
        ride.setSeats(rideRequest.getSeats());
        ride.setTime(rideRequest.getTime());
        ride.setDescription(rideRequest.getDescription());
        ride.setPrice(rideRequest.getPrice());
        ride.setUsername(rideRequest.getUsername());

        rideRepository.save(ride);
    }

    public List<RideResponse> getAllRides() {
        List<Ride> rides = rideRepository.findAll();

        return rides.stream().map(ride -> mapToRideResponse(ride)).toList();
    }

    private RideResponse mapToRideResponse(Ride ride) {
        RideResponse rideResponse = new RideResponse();
        rideResponse.setId(ride.getId());
        rideResponse.setPickup(ride.getPickup());
        rideResponse.setDestination(ride.getDestination());
        rideResponse.setDescription(ride.getDescription());
        rideResponse.setTime(ride.getTime());
        rideResponse.setSeats(ride.getSeats());
        rideResponse.setPrice(ride.getPrice());
        rideResponse.setUsername(ride.getUsername());

        return rideResponse;
    }

    public RideResponse getRides(long id) {
        Ride ride = rideRepository.findById(id).orElse(null);
        if (ride != null) {
            RideResponse rideResponse = mapToRideResponse(ride);
            return rideResponse;
        }

        return null;
    }
}
