package com.example.billingservice.service.impl;


import com.example.billingservice.dto.BillingRequest;
import com.example.billingservice.dto.FundAccountRequest;
import com.example.billingservice.dto.ServiceResponse;
import com.example.billingservice.model.Billing;
import com.example.billingservice.repository.BillingRepository;
import com.example.billingservice.service.BillingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;
    private final KafkaTemplate kafkaTemplate;

    @Override
    public ServiceResponse fundCustomerAccount(FundAccountRequest request) {
        try {
            UUID uuid=UUID.randomUUID();
            Billing billing = Billing.builder()
                    .customerId(request.getCustomerId())
                    .amount(request.getAmount())
                    .tranId(uuid.toString())
                    .status("PENDING").build();

            BillingRequest billingRequest = BillingRequest.builder()
                    .customerId(request.getCustomerId())
                    .amount(request.getAmount())
                    .tranId(uuid.toString())
                    .status("PENDING").build();

            log.info("Pushing message to kafka topic");
            kafkaTemplate.send("fundAccount", billingRequest);
            billingRepository.save(billing);
        } catch (Exception e) {
            return new ServiceResponse("01", "ERROR");
        }
        return new ServiceResponse("00", "SUCCESS");
    }


}
