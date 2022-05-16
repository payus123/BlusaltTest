package com.example.billingservice.service;


import com.example.billingservice.dto.FundAccountRequest;
import com.example.billingservice.dto.ServiceResponse;

public interface BillingService {

     ServiceResponse fundCustomerAccount(FundAccountRequest request);
}
