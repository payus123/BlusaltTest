package com.blusalt.customerservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BillingServiceRequest {
    private Long customerId;
    private BigDecimal amount;
    private String status;
}
