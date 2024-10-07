package com.smart.service.customer;

import org.springframework.http.ResponseEntity;

import com.smart.dto.AddProductInCartDto;

public interface CartService {

	ResponseEntity<?> addProducts(AddProductInCartDto addProsuctInCartDto);
}
