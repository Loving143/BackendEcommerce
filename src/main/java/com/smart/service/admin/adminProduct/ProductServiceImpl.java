package com.smart.service.admin.adminProduct;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		return "true";
	}

}
