package com.os.dto;

import java.util.List;

public class OrderReqDTO {
	
	private Long userId;

	private List<Long> productIds;

	public OrderReqDTO(Long userId, List<Long> productIds) {
		super();
		this.userId = userId;
		this.productIds = productIds;
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
	
	

}
