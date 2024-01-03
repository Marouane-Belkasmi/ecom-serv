package com.emsi.orderservice;

import com.emsi.orderservice.entities.Order;
import com.emsi.orderservice.entities.ProductItem;
import com.emsi.orderservice.enums.OrderStatus;
import com.emsi.orderservice.model.Customer;
import com.emsi.orderservice.model.Product;
import com.emsi.orderservice.repository.OrderRepository;
import com.emsi.orderservice.repository.ProductItemRepository;
import com.emsi.orderservice.service.CustomerRestClientService;
import com.emsi.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClientService customerRestClientService,
							InventoryRestClientService inventoryRestClientService) {
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();
			Long customerId = 1L;
			Customer customer = customerRestClientService.customerById(customerId);
			Random random = new Random();
			for (int i=0; i < 20; i++){
				Order order = Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5? OrderStatus.PENDING:OrderStatus.CREATED)
						.createdAt(new Date())
						.build();
				Order savedOrder = orderRepository.save(order);
				for(int j = 0; j < products.size(); j++) {
					if(Math.random()>0.70) {
						ProductItem productItem = ProductItem.builder()
								.order(savedOrder)
								.price(products.get(j).getPrice())
								.quantity(random.nextInt(100))
								.productId(products.get(j).getId())
								.discount(Math.random())
								.build();

						productItemRepository.save(productItem);
					}
				}
			}
		};
	}
}
