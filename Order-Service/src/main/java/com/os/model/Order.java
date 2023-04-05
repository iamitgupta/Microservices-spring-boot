package com.os.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "tb_order")
@Entity
public class Order {

	@Id
	@SequenceGenerator(name = "order_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	private Long id;

	private Long userId;

	private List<Long> productIds;

	private Double totalPrice;

	private String deliverTo;
	
	

	public Order() {
		super();
	}

	public Order(Long id, Long userId, List<Long> productIds, Double totalPrice, String deliverTo) {
		super();
		this.id = id;
		this.userId = userId;
		this.productIds = productIds;
		this.totalPrice = totalPrice;
		this.deliverTo = deliverTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo) {
		this.deliverTo = deliverTo;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", productIds=" + productIds + ", totalPrice=" + totalPrice
				+ ", deliverTo=" + deliverTo + "]";
	}
	
	
	

}
