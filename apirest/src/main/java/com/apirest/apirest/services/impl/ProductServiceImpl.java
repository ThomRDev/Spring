package com.apirest.apirest.services.impl;

import com.apirest.apirest.domain.Product;
import com.apirest.apirest.domain.ProductDto;
import com.apirest.apirest.domain.responses.ProductsResponse;
import com.apirest.apirest.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDto> getProducts() {
        var arr = new ArrayList<ProductDto>();
        var p = new Product();
        p.setId(1);
        p.setBrand("brand");
        p.setName("name");
        p.setPrice(45);
        arr.add(new ProductDto(p));
        return arr;
    }
    @Override
    public ProductsResponse _getProducts() {
        var arr = new ArrayList<Product>();
        var p = new Product();
        p.setId(1);
        p.setBrand("brand");
        p.setName("name");
        p.setPrice(45);
        arr.add(p);
        return new ProductsResponse(arr);
    }
}
