package com.emsi.orderservice.service;

import com.emsi.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping(path = "/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);

    @GetMapping(path = "/products?projection=fullProduct")
    public PagedModel<Product> allProducts();

}
