package com.example.billingworkerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "resloved_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResolvedTransactions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tranId;
    private BigDecimal amount;
}
