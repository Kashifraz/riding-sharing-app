package com.kashif.billingmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_billing")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long bookingId;
    private long rideId;
    private float totalAmount;
    private Integer totalSeats;
    private float price;
    private String username;
}
