package com.smart.service.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dto.ProductDto;
import com.smart.entity.Product;
import com.smart.repository.admin.product.ProductRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<ProductDto> getAllProducts(){
		System.out.println("This is the Product");
		List<Product>products = productRepository.findAll();
		return products.stream().map(Product :: getDto).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getProductsByName(String name) {
		List<Product> products = productRepository.findAllByName(name);
		return products.stream().map(Product:: getDto).collect(Collectors.toList()); 
	
	}
}
