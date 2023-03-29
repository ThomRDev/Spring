package com.romelce.ecommerce.category.service;

import com.romelce.ecommerce.category.domain.Category;
import com.romelce.ecommerce.category.domain.dto.CreateCategoryDto;
import com.romelce.ecommerce.category.domain.dto.UpdateCategoryDto;
import com.romelce.ecommerce.category.domain.responses.ResponseCategories;
import org.springframework.stereotype.Service;

public interface CategoryService {
	Category createCategory(CreateCategoryDto createCategoryDto);

	ResponseCategories getAll();

	Category getById(Long id);

	Category update(UpdateCategoryDto updateCategoryDto);
}
