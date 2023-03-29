package com.thomcompany.springsecurity.product.domain.responses;

import com.thomcompany.springsecurity.product.domain.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsResponse {
    List<Product> products;
}
