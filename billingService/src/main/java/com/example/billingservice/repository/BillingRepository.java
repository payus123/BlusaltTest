package com.example.billingservice.repository;

import com.example.billingservice.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long> {
    @Override
    Optional<Billing> findById(Long id);
    Billing findByTranId(String id);

}
