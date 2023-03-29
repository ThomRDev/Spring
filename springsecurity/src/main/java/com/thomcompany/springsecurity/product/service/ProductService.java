package com.thomcompany.springsecurity.product.service;

import com.thomcompany.springsecurity.product.domain.Product;
import com.thomcompany.springsecurity.product.domain.responses.ProductsResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductsResponse getAll();
    Optional<Product> getById(Long id);
}
