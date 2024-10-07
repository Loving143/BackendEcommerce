package com.smart.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.AddProductInCartDto;
import com.smart.service.customer.CartService;

import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("/api/customer")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Transactional
	@PostMapping("/cart")
	public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){
		return cartService.addProducts(addProductInCartDto);
	}

}
