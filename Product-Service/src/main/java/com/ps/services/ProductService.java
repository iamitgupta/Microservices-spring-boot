package com.ps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.model.Product;
import com.ps.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product getProductById(Long productId) {
		return repository.findById(productId).get();
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	public String deleteProductById(Long productId) {
		repository.deleteById(productId);
		if (repository.findById(productId).isEmpty()) {
			return "Product with id : " + productId + " deleted";
		}
		return "Failed to delete Product with id : " + productId;

	}

	public List<Product> getAllProductsByIds(List<Long> productId) {
		return repository.findAllById(productId);
	}

}
