package com.apirest.apirest.controller;

import com.apirest.apirest.domain.ProductDto;
import com.apirest.apirest.domain.responses.ProductsResponse;
import com.apirest.apirest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class RestProductController {

    @Autowired
    private ProductService productService; // ira al contenedor de objetos de spring, buscara una implementacion que tenga prodtSerice
    // si esa interfaz tiene mas de una implementacion enviara un error y le podemos recir que nos de uno en concreto con el nombre del service("blalb")
    // @Qualifier("myServiceImpl1")
    @GetMapping("products-v1")
    public ResponseEntity<List<ProductDto>> getProducts(){
        //return ResponseEntity.ok(this.productService.getProducts());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type","application/json")
                .body(this.productService.getProducts());
    }

    //por estandar List<ProductDto>> se debe de abstraer en una sola clase respuesta en el dominio

    @GetMapping("products-v2")
    public ResponseEntity<ProductsResponse> _products(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type","application/json")
                .body(this.productService._getProducts());
    }


}
