package com.smart.service.admin.category;

import java.util.List;

import com.smart.dto.CategoryDto;
import com.smart.entity.Category;

public interface CategoryService {

	Category createCategory(CategoryDto category);

	List<Category> getAllCategory();

}
