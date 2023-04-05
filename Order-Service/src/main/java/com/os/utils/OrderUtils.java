package com.os.utils;

import java.util.List;

import com.os.model.Product;


public class OrderUtils {

	public static Double calculateOrderprice(List<Product> products) {
		
		return products.stream()
		.mapToDouble(Product::getPrice)
		.sum();
		
	} 
}
