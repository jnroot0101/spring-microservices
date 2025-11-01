package com.shaheenbot.inventoryservice;

import com.shaheenbot.inventoryservice.models.Product;
import com.shaheenbot.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            Product p1 = Product.builder().name("p1").description("p1 desc").build();
            Product p2 = Product.builder().name("p2").description("p2 desc").build();
            List<Product> products = Arrays.asList(p1, p2);

            productRepository.saveAll(products);
        };
    }
}
