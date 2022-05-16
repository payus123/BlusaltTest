package com.example.billingservice.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class FundAccountRequest {
    private String customerId;
    private BigDecimal amount;
    private String status;
}
