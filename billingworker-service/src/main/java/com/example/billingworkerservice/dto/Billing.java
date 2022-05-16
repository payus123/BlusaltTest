package com.example.billingworkerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
    private String customerId;
    private String tranId;
    private BigDecimal amount;
    private String status;

}
