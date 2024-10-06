package com.smart.repository.admin.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findAllByName(String name);
}
