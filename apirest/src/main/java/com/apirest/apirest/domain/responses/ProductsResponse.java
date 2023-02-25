package com.apirest.apirest.domain.responses;

import com.apirest.apirest.domain.Product;
import com.apirest.apirest.domain.ProductDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductsResponse {

    private List<ProductDto> products;

    public ProductsResponse(List<Product> listProducts){
        this.products = new ArrayList<>();

        for (Product pro: listProducts) {
            ProductDto productDto = new ProductDto();
            productDto.setId(pro.getId());
            productDto.setName(pro.getName());
            productDto.setBrand(pro.getBrand());
            productDto.setPrice(pro.getPrice());
            this.products.add(productDto);
        }
    }
}
