package com.blusalt.customerservice.controller;


import com.blusalt.customerservice.dto.FundAccountRequest;
import com.blusalt.customerservice.dto.ServiceResponse;
import com.blusalt.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/fundAccount")
    public ResponseEntity<ServiceResponse>fundAccount(@RequestBody FundAccountRequest request){
        ServiceResponse serviceResponse = null;
          serviceResponse = customerService.fundCustomerAccount(request);
        if (Objects.equals(serviceResponse.getCode(),"00")) {
            return ResponseEntity.ok(serviceResponse);
        }
        return ResponseEntity.badRequest().body(serviceResponse);

    }
    @GetMapping("/test")
    public ResponseEntity<String>testConnection(){

        return ResponseEntity.badRequest().body("Hello world");

    }
}
