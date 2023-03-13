package com.synopsis.dbdemo.service.impl;

import com.synopsis.dbdemo.domain.Product;
import com.synopsis.dbdemo.domain.dto.ProductDto;
import com.synopsis.dbdemo.repository.ProductRepository;
import com.synopsis.dbdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getById(Long id) {
		return null;
	}

	@Override
	public Product getByName(String name) {
		return null;
	}

	@Override
	public void createProduct(ProductDto productDto) {
		Product product = Product.builder()
				.name(productDto.getName())
				.price(productDto.getPrice())
				.stock(productDto.getStock())
				.build();
		this.productRepository.save(product);
	}
}
