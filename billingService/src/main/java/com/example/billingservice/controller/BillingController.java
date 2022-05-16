package com.example.billingservice.controller;

import com.example.billingservice.dto.FundAccountRequest;
import com.example.billingservice.dto.ServiceResponse;
import com.example.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("billing")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService billingService;

    @PostMapping("/fundAccount")
    public ResponseEntity<ServiceResponse>fundAccount(@RequestBody FundAccountRequest request){
        ServiceResponse serviceResponse;
          serviceResponse = billingService.fundCustomerAccount(request);
        if (Objects.equals(serviceResponse.getCode(),"00")) {
            return ResponseEntity.ok(serviceResponse);
        }
        return ResponseEntity.badRequest().body(serviceResponse);

    }
}
