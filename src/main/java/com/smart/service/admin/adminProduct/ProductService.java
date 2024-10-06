package com.smart.service.admin.adminProduct;

import java.io.IOException;
import java.util.List;

import com.smart.dto.ProductDto;
import com.smart.entity.Product;

public interface ProductService {

	Product addProduct(ProductDto dto) throws IOException;
	List<ProductDto> getAllProducts();
	List<ProductDto> getProductsByName(String title);
	String deleteProduct(Integer productId);
}
