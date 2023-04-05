package com.os.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.os.dto.OrderReqDTO;
import com.os.model.Order;
import com.os.services.OrderService;

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
	public ResponseEntity<Object> placeOrder(@RequestBody OrderReqDTO order){
		return ResponseEntity.status(HttpStatus.SC_CREATED).body(service.placeOrder(order));
	}

}
