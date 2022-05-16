package com.example.billingservice.listeners;


import com.example.billingservice.dto.ResolvedTransactions;
import com.example.billingservice.model.Billing;
import com.example.billingservice.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TranResolvedListeners {
    @Autowired
    private BillingRepository billWorkerRepistory;

    @KafkaListener(topics = "resolveFunding", groupId = "groupId")
    void listener(ResolvedTransactions data) {
        System.out.println("RECEIVED: " + data);
        try {
            Billing transaction = billWorkerRepistory.findByTranId(data.getTranId());
            transaction.setStatus("SUCCESS");
            billWorkerRepistory.save(transaction);


        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
}
