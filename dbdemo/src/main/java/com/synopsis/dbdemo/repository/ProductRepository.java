package com.synopsis.dbdemo.repository;

import com.synopsis.dbdemo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
	List<Product> findByPrice(Double price);
}