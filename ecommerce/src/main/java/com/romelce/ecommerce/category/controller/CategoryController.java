package com.romelce.ecommerce.category.controller;

import com.romelce.ecommerce.category.domain.Category;
import com.romelce.ecommerce.category.domain.dto.CreateCategoryDto;
import com.romelce.ecommerce.category.domain.responses.ResponseCategories;
import com.romelce.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService service;

	@PostMapping
	public ResponseEntity<Category> create(@RequestBody @Valid CreateCategoryDto request) {
		return ResponseEntity.ok(this.service.createCategory(request));
	}

	@GetMapping
	public ResponseEntity<ResponseCategories> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
}
