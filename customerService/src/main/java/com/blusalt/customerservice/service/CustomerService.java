package com.blusalt.customerservice.service;

import com.blusalt.customerservice.dto.FundAccountRequest;
import com.blusalt.customerservice.dto.ServiceResponse;

public interface CustomerService {

     ServiceResponse fundCustomerAccount(FundAccountRequest request);
}
