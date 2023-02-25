package com.apirest.apirest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // permite establecer en null a las variables en el json
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private String brand;

    private int price;

    public ProductDto(Product product){
        this.id     = product.getId();
        this.name   = product.getName();
        this.brand  = product.getBrand();
        this.price = product.getPrice();
    }
}
