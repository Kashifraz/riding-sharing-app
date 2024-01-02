package com.kashif.drivermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RideResponse {
    private long id;
    private String pickup;
    private String destination;
    private String description;
    private String time;
    private Integer seats;
    private float price;
    private String username;
}
