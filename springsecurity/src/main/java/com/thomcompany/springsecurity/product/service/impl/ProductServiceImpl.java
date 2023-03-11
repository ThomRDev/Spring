package com.thomcompany.springsecurity.product.service.impl;

import com.thomcompany.springsecurity.product.domain.Product;
import com.thomcompany.springsecurity.product.domain.responses.ProductsResponse;
import com.thomcompany.springsecurity.product.repository.ProductRepository;
import com.thomcompany.springsecurity.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductsResponse getAll() {
        var products = this.productRepository.findAll();
        return ProductsResponse.builder().products(products).build();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return this.productRepository.findById(id);
    }
}
