package com.romelce.ecommerce.product.service.impl;

import com.romelce.ecommerce.product.domain.Product;
import com.romelce.ecommerce.product.domain.dto.CreateProductDto;
import com.romelce.ecommerce.product.domain.responses.ProductsResponse;
import com.romelce.ecommerce.product.repository.ProductRepository;
import com.romelce.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product create(CreateProductDto productDto) {
		return null;
	}

	@Override
	public ProductsResponse getAll() {
		return ProductsResponse.builder().products(this.productRepository.findAll()).build();
	}
}
