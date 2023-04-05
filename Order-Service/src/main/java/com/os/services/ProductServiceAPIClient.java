package com.os.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.os.model.Product;

@FeignClient(value = "product-service")
@Component
public interface ProductServiceAPIClient {

	@GetMapping(value = "product/getallbyid", produces = "application/json")
	List<Product> getAllProductsById(@RequestParam List<Long> productId);

}
