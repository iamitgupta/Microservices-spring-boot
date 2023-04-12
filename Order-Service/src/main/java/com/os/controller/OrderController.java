package com.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.dto.OrderReqDTO;
import com.os.services.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public String hello() {
		return "Order service running fine !";
	}
	
	
	
	@PostMapping("/place")
    @CircuitBreaker(name = "product", fallbackMethod = "productFallback")
	public ResponseEntity<Object> placeOrder(@RequestBody OrderReqDTO order){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.placeOrder(order));
	}
	
	public ResponseEntity<String> productFallback(OrderReqDTO order, RuntimeException runtimeException) {
		return ResponseEntity.status(HttpStatus.OK).body("Oops! Something went wrong, please retry later!");
	}
	

}
