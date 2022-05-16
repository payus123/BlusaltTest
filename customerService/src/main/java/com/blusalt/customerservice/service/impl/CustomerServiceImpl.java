package com.blusalt.customerservice.service.impl;

import com.blusalt.customerservice.dto.BillingServiceRequest;
import com.blusalt.customerservice.dto.FundAccountRequest;
import com.blusalt.customerservice.dto.ServiceResponse;
import com.blusalt.customerservice.model.Customer;
import com.blusalt.customerservice.repository.CustomerRepository;
import com.blusalt.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private RestTemplate restTemplate;
    private final CustomerRepository customerRepository;

    @Override
    public ServiceResponse fundCustomerAccount(FundAccountRequest request) {
        try {
            Optional<Customer> response = customerRepository.findCustomerByAccountNumber(request.getAccountNumber());
            if (!response.isPresent()) {
                throw new EntityNotFoundException("Customer not Found");
            }
            Customer customer = response.get();
            BillingServiceRequest requestBuilder = BillingServiceRequest.builder()
                    .amount(request.getAmount())
                    .customerId(customer.getId()).build();

            HttpEntity requestToSend = new HttpEntity(requestBuilder);
            String resourceUrl = "http://api-gateway:8000/BILL-SERVICE/billing/fundAccount";
            ResponseEntity<ServiceResponse> serviceResponse = restTemplate.exchange(resourceUrl, HttpMethod.POST, requestToSend, ServiceResponse.class);
            return serviceResponse.getBody();

        } catch (Exception e) {
            return new ServiceResponse("01", e.getMessage());
        }
    }
}
