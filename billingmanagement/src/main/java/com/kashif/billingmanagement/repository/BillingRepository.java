package com.kashif.billingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashif.billingmanagement.model.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    
}
