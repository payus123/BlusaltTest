package com.example.billingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "billing")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String tranId;
    private String customerId;
    private BigDecimal amount;
    private String status;

}
