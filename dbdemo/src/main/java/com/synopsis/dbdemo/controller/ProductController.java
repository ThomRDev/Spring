package com.synopsis.dbdemo.controller;


import com.synopsis.dbdemo.domain.Product;
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

	@PutMapping("/{id}")
	public ResponseEntity<Map<String,Object>> editProductById(@RequestBody ProductDto productDto, @PathVariable("id") Long productId){
		Product product = this.productService.update(productDto,productId);
		Map<String,Object> response = new HashMap<>();
		response.put("msg","Product actualizado con exito");
		response.put("product",product);
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,String>> delete(@PathVariable("id") Long productId){
		this.productService.deleteProductById(productId);
		Map<String,String> response = new HashMap<>();
		response.put("msg","Product eliminado con exito");
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
