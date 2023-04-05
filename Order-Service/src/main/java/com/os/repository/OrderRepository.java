package com.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.os.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
