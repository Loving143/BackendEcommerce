package com.smart.service.customer;

import java.util.List;

import com.smart.dto.ProductDto;

public interface CustomerService {

	List<ProductDto> getAllProducts();
	List<ProductDto> getProductsByName(String title);
}
