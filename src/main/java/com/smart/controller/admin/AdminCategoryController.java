package com.smart.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.dto.CategoryDto;
import com.smart.entity.Category;
import com.smart.service.admin.category.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto category) {
		Category cat = categoryService.createCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}
	
	@GetMapping("get/allCategory")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategory();
	}

}
