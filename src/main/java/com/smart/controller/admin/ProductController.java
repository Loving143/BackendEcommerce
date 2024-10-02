package com.smart.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.ProductDto;
import com.smart.entity.Product;
import com.smart.service.admin.adminProduct.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("add/product")
	public ResponseEntity<Product> addProduct(@ModelAttribute ProductDto dto) throws IOException{
		Product product = productService.addProduct(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}
