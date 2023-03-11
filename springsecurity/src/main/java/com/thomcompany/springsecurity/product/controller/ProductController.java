package com.thomcompany.springsecurity.product.controller;

import com.thomcompany.springsecurity.auth.dto.AuthResponseDto;
import com.thomcompany.springsecurity.auth.dto.RegisterRequestDto;
import com.thomcompany.springsecurity.product.domain.responses.ProductsResponse;
import com.thomcompany.springsecurity.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<ProductsResponse> getProducts() {
        return ResponseEntity.ok(this.productService.getAll());
    }
}
