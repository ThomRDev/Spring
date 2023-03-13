package com.synopsis.dbdemo.service;

import com.synopsis.dbdemo.domain.Product;
import com.synopsis.dbdemo.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
	List<Product> getAll();

	Product getById(Long id);

	Product getByName(String name);

	void createProduct(ProductDto productDto);
}
