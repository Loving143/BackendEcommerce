package com.smart.service.admin.adminProduct;

import java.io.IOException;

import com.smart.dto.ProductDto;
import com.smart.entity.Product;

public interface ProductService {

	Product addProduct(ProductDto dto) throws IOException;

}
