package com.app.customerservice;

import com.app.customerservice.models.Customer;
import com.app.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            Customer c1 = Customer.builder()
                    .firstName("John")
                    .lastName("Smith")
                    .email("john.smith@example.com")
                    .build();
            Customer c2 = Customer.builder()
                    .firstName("Adam")
                    .lastName("Marven")
                    .email("adam.marven@example.com")
                    .build();

            List<Customer> customers = new ArrayList<>();
            customers.add(c1);
            customers.add(c2);

            customerRepository.saveAll(customers);
        };
    }
}
