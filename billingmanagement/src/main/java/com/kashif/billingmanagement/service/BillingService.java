package com.kashif.billingmanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.kashif.billingmanagement.dto.BillingRequest;
import com.kashif.billingmanagement.dto.BillingResponse;
import com.kashif.billingmanagement.model.Billing;
import com.kashif.billingmanagement.repository.BillingRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class BillingService {
    private final BillingRepository billingRepository;

    public void generateBill(BillingRequest billingRequest) {
        Billing billing = new Billing();
        billing.setBookingId(billingRequest.getBookingId());
        billing.setRideId(billingRequest.getRideId());
        billing.setTotalSeats(billingRequest.getTotalSeats());
        billing.setPrice(billingRequest.getPrice());
        billing.setTotalAmount(billing.getPrice() * billing.getTotalSeats());
        billing.setUsername(billingRequest.getUsername());

        billingRepository.save(billing);
    }

    public List<BillingResponse> billingHistory() {
        List<Billing> Bills = billingRepository.findAll();

        return Bills.stream().map(Bill -> mapToBillResponse(Bill)).toList();
    }

    private BillingResponse mapToBillResponse(Billing Bill) {
        BillingResponse billResponse = new BillingResponse();
        billResponse.setId(Bill.getId());
        billResponse.setBookingId(Bill.getBookingId());
        billResponse.setRideId(Bill.getRideId());
        billResponse.setTotalSeats(Bill.getTotalSeats());
        billResponse.setPrice(Bill.getPrice());
        billResponse.setTotalAmount(Bill.getTotalAmount());
        billResponse.setUsername(Bill.getUsername());

        return billResponse;
    }

    public BillingResponse printBill(long id) {
        Billing Bill = billingRepository.findById(id).orElse(null);
        if (Bill != null) {
            BillingResponse billResponse = mapToBillResponse(Bill);
            return billResponse;
        }

        return null;
    }
}
