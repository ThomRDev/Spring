package com.romelce.ecommerce.category.service.impl;

import com.romelce.ecommerce.category.domain.Category;
import com.romelce.ecommerce.category.domain.dto.CreateCategoryDto;
import com.romelce.ecommerce.category.domain.dto.UpdateCategoryDto;
import com.romelce.ecommerce.category.domain.responses.ResponseCategories;
import com.romelce.ecommerce.category.errors.CategoryException;
import com.romelce.ecommerce.category.reposistory.CategoryRepository;
import com.romelce.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(CreateCategoryDto createCategoryDto) {
		try {
			return this.categoryRepository.save(
					Category.builder()
							.name(createCategoryDto.getName())
							.build()
			);
		}catch (Exception ex){
			throw new CategoryException("Error al crear una categoria");
		}
	}

	@Override
	public ResponseCategories getAll() {
		ResponseCategories responseCategories = ResponseCategories.builder().categories(this.categoryRepository.findAll()).build();
		return responseCategories;
	}

	@Override
	public Category getById(Long id) {
		return null;
	}

	@Override
	public Category update(UpdateCategoryDto updateCategoryDto) {
		return null;
	}
}
