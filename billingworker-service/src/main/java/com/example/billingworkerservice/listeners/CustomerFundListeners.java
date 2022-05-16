package com.example.billingworkerservice.listeners;

import com.example.billingworkerservice.model.ResolvedTransactions;
import com.example.billingworkerservice.dto.Billing;
import com.example.billingworkerservice.repository.BillWorkerRepistory;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class CustomerFundListeners {
   private final KafkaTemplate kafkaTemplate;
   private final BillWorkerRepistory billWorkerRepistory;

    @KafkaListener(topics = "fundAccount",groupId = "groupId")
    void listener(Billing data){
        try {
            TimeUnit.SECONDS.sleep(Double.valueOf(0.1).longValue());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("RECEIVED: "+data);
        ResolvedTransactions resolvedTransaction = ResolvedTransactions.builder().amount(data.getAmount()).tranId(data.getTranId()).build();
        kafkaTemplate.send("resolveFunding",resolvedTransaction);
        billWorkerRepistory.save(resolvedTransaction);



    }
}