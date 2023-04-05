package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
