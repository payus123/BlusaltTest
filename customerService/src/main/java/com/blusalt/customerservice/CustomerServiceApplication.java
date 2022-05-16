package com.blusalt.customerservice;

import com.blusalt.customerservice.model.Customer;
import com.blusalt.customerservice.repository.CustomerRepository;
import com.blusalt.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

@EnableEurekaClient
public class CustomerServiceApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer = Customer.builder().firstName("Victor")
                .lastName("Akpovero").accountNumber("3137543778").phoneNumber("09012325901").build();
        customerRepository.save(customer);
    }
}
