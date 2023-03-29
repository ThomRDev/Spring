package com.apirest.apirest.services;

import com.apirest.apirest.domain.ProductDto;
import com.apirest.apirest.domain.responses.ProductsResponse;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductsResponse _getProducts();

    ProductDto getProduct(Integer productId);
}


// toda la logica de negocio debe de ir en la capa de servicio