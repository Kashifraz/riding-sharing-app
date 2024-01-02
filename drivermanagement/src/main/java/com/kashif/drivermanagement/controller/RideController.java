package com.kashif.drivermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kashif.drivermanagement.dto.RideRequest;
import com.kashif.drivermanagement.dto.RideResponse;
import com.kashif.drivermanagement.service.RideService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/ride")
@AllArgsConstructor

public class RideController {

    private final RideService rideService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public String createRide(@RequestBody RideRequest rideRequest) {
        rideService.createRide(rideRequest);
        return "ride created successfully";
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<RideResponse> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/show/{rideid}")
    @ResponseStatus(HttpStatus.OK)
    private RideResponse getRides(@PathVariable("rideid") int id) {
        return rideService.getRides(id);
    }

}
