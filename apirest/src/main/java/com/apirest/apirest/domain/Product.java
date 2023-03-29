package com.apirest.apirest.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity // indica que sera una entidad de persistencia
// que tome la tabla product de la base de datos apiRestDB

// @Table(name = "product", catalog = "apiRestDB") // se traduce a la base de datos api_rest_dB y la tabla product
// pero en la conexion ya especifique la basae de datos
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // la estratega para el id sera automecrementable
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;
    @Column(name = "product_brand")
    private String brand;// en un futuro será otra entidad

    @Column(name = "product_price")
    private Integer price;

    @Column(name = "product_stock")
    private Integer stock;
}
