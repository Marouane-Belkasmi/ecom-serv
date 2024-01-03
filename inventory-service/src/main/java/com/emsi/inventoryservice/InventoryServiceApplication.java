package com.emsi.inventoryservice;

import com.emsi.inventoryservice.entities.Product;
import com.emsi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder()
							.name("Ord HP 6540")
							.price(6000)
							.build(),
					Product.builder()
							.name("Imprimante Epson")
							.price(1000)
							.build(),
					Product.builder()
							.name("PC Dell")
							.price(8000)
							.build()
			));

			productRepository.findAll().forEach(System.out::println);
		};
	}
}
