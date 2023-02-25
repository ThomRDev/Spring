package com.apirest.apirest.services;

import com.apirest.apirest.domain.ProductDto;
import com.apirest.apirest.domain.responses.ProductsResponse;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductsResponse _getProducts();
}


// toda la logica de negocio debe de ir en la capa de servicio