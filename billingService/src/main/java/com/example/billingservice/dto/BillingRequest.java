package com.example.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingRequest {
    private String customerId;
    private BigDecimal amount;
    private String tranId;
    private String status;

}
