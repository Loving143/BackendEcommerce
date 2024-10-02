package com.smart.service.admin.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dto.CategoryDto;
import com.smart.entity.Category;
import com.smart.repository.admin.category.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category createCategory(CategoryDto category) {
		Category cat = new Category(category);
		return categoryRepository.save(cat);
		}
	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

}
