package com.synopsis.dbdemo.controller;


import com.synopsis.dbdemo.domain.dto.ProductDto;
import com.synopsis.dbdemo.domain.responses.ProductResponse;
import com.synopsis.dbdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ResponseEntity<ProductResponse> getAll(){
		ProductResponse response = ProductResponse.builder().products(this.productService.getAll()).build();
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/")
	public ResponseEntity<Map<String,String>> createProduct(@RequestBody ProductDto productDto){
		this.productService.createProduct(productDto);
		Map<String,String> response = new HashMap<>();
		response.put("msg","Product creado correctamente");
		return ResponseEntity.ok().body(response);
	}
}
