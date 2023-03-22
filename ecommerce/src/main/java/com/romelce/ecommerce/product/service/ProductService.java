package com.romelce.ecommerce.product.service;

import com.romelce.ecommerce.product.domain.Product;
import com.romelce.ecommerce.product.domain.dto.CreateProductDto;
import com.romelce.ecommerce.product.domain.responses.ProductsResponse;

public interface ProductService {
	Product create(CreateProductDto productDto);

	ProductsResponse getAll();
}
