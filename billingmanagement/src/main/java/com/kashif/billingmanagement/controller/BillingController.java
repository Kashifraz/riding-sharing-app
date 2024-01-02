package com.kashif.billingmanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kashif.billingmanagement.dto.BillingRequest;
import com.kashif.billingmanagement.dto.BillingResponse;
import com.kashif.billingmanagement.service.BillingService;
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
@RequestMapping("/api/billing")
@AllArgsConstructor

public class BillingController {

    private final BillingService billingService;

    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public String generateBill(@RequestBody BillingRequest billRequest) {
        billingService.generateBill(billRequest);
        return "Bill created successfully";
    }

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public List<BillingResponse> billingHistory() {
        return billingService.billingHistory();
    }

    @GetMapping("/print/{billid}")
    @ResponseStatus(HttpStatus.OK)
    private BillingResponse printBill(@PathVariable("billid") int id) {
        return billingService.printBill(id);
    }

}
