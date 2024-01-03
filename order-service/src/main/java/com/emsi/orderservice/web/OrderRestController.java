package com.emsi.orderservice.web;

import com.emsi.orderservice.entities.Order;
import com.emsi.orderservice.model.Customer;
import com.emsi.orderservice.repository.OrderRepository;
import com.emsi.orderservice.repository.ProductItemRepository;
import com.emsi.orderservice.service.CustomerRestClientService;
import com.emsi.orderservice.service.InventoryRestClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping(path = "/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryRestClientService.productById(productItem.getProductId()));
        });
        return order;
    }
}
