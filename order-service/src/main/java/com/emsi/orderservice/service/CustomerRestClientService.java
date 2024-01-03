package com.emsi.orderservice.service;

import com.emsi.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClientService {
    @GetMapping(path = "/customers/{id}?projection=fullCustomer")
    public Customer customerById(@PathVariable Long id);

    @GetMapping(path = "/customers?projection=fullCustomer")
    public PagedModel<Customer> allCustomers();

}
