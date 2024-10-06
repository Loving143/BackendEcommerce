package com.smart.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.ProductDto;
import com.smart.entity.Product;
import com.smart.service.admin.adminProduct.ProductService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/admin")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("add/product")
	public ResponseEntity<Product> addProduct(@ModelAttribute ProductDto dto) throws IOException{
		Product product = productService.addProduct(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
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
	
	@DeleteMapping("/delete/product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer productId){
		return ResponseEntity.ok(productService.deleteProduct(productId)); 
	}

}
