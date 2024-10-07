package com.smart.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.ProductDto;
import com.smart.service.admin.adminProduct.ProductService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private ProductService productService;
	@GetMapping("/get/allProducts")
	public ResponseEntity<List<ProductDto>>getAllProducts(){
		List<ProductDto> productDtos = productService.getAllProducts();
		return ResponseEntity.ok(productDtos);
	}
	
	@Transactional
	@GetMapping("/search/{name}")
	public ResponseEntity<List<ProductDto>> getProductsByName(@PathVariable String name){
		List<ProductDto> productsDto =productService.getProductsByName(name);
		return ResponseEntity.ok(productsDto); 
	}

}
