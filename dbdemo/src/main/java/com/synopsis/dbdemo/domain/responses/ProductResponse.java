package com.synopsis.dbdemo.domain.responses;

import com.synopsis.dbdemo.domain.Product;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	private List<Product> products;
}
