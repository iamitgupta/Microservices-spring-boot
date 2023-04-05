package com.ps.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps.model.Product;
import com.ps.services.ProductService;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.QueryParam;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	private ResponseEntity<Object> saveUser(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.SC_CREATED).body(service.saveProduct(product));
	}

	@GetMapping("/get/{productId}")
	private ResponseEntity<Product> getProductById(@PathParam("productId") final Long productId) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.getProductById(productId));

	}

	@GetMapping("/getall")
	private ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.getAllProducts());

	}

	@GetMapping("/getallbyid")
	private ResponseEntity<List<Product>> getAllProductsByIds(@RequestParam List<Long> productId) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.getAllProductsByIds(productId));

	}

	@PutMapping("/update")
	private ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.updateProduct(product));
	}

	@DeleteMapping("/delete/{productId}")
	private ResponseEntity<String> deleteProductById(@PathParam("productId") final Long productId) {
		return ResponseEntity.status(HttpStatus.SC_OK).body(service.deleteProductById(productId));

	}

}
