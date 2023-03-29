package com.romelce.ecommerce.product.domain.responses;

import com.romelce.ecommerce.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
	private List<Product> products;
}
