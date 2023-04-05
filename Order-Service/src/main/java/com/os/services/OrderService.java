package com.os.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import com.os.dto.OrderReqDTO;
import com.os.model.Order;
import com.os.model.Product;
import com.os.model.User;
import com.os.repository.OrderRepository;
import com.os.utils.OrderUtils;

@Service
public class OrderService {

	@Autowired
	private ProductServiceAPIClient productService;

	@Autowired
	private UserServiceAPIClient userService;
	
	@Autowired
	private OrderRepository repository;

	public Order placeOrder(OrderReqDTO orderdto) {
		Order order = new Order();
		BeanUtils.copyProperties(orderdto, order);
		List<Product> products = productService.getAllProductsById(order.getProductIds());

		Double totalprice = OrderUtils.calculateOrderprice(products);
		order.setTotalPrice(totalprice);

		User user = userService.getUserById(order.getUserId());
		order.setDeliverTo(user.getAddress());
		
		return repository.save(order);

	}

}
