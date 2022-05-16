package com.example.billingworkerservice.repository;

import com.example.billingworkerservice.model.ResolvedTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillWorkerRepistory extends JpaRepository<ResolvedTransactions,Long> {
}
