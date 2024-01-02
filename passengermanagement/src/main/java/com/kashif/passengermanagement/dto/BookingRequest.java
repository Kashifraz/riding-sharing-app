package com.kashif.passengermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookingRequest {
    private long ride_id;
    private String user_name;
    private String user_phone;
    private Integer seats;
}
