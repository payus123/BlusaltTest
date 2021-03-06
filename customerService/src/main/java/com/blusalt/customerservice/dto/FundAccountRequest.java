package com.blusalt.customerservice.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class FundAccountRequest {
    private String accountNumber;
    private BigDecimal amount;
}
