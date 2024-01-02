package com.kashif.billingmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BillingResponse {
    private long id;
    private long bookingId;
    private long rideId;
    private float totalAmount;
    private Integer totalSeats;
    private float price;
    private String username;
}
