package com.smart.service.admin.adminProduct;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dto.ProductDto;
import com.smart.entity.Category;
import com.smart.entity.Product;
import com.smart.repository.admin.category.CategoryRepository;
import com.smart.repository.admin.product.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Product addProduct(ProductDto dto) throws IOException {
		Product product =new Product(dto);
		Category cat = categoryRepository.findById(dto.getCategoryId()).orElse(null);
		product.setCategory(cat);
		return productRepository.save(product);
		
		
	}

}
