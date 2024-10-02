package com.smart.repository.admin.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
