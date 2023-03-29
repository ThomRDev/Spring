package com.synopsis.dbdemo.service.impl;

import com.synopsis.dbdemo.domain.Product;
import com.synopsis.dbdemo.domain.dto.ProductDto;
import com.synopsis.dbdemo.repository.ProductRepository;
import com.synopsis.dbdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


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

	@Override
	public Product update(ProductDto productDto, Long id) {
		Product product = this.productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El producto con el id :"+id+" no existe"));
		if (Objects.nonNull(productDto.getName()) && !"".equalsIgnoreCase(productDto.getName())) {
			product.setName(productDto.getName());
		}

		if (productDto.getPrice() != null) {
			product.setPrice(productDto.getPrice());
		}
		if (productDto.getStock() != null) {
			product.setStock(productDto.getStock());
		}

		return this.productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		Product product = this.productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El producto con el id :"+id+" no existe"));
		this.productRepository.deleteById(id);
	}
}
