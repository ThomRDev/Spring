package com.apirest.apirest.domain;

import lombok.*;

/*
@Getter : que genere los getter
@Setter : que genere los setter
@AllArgsConstructor : que genere un constructor con todos los argumentos
@NoArgsConstructor : que genere un cosntructor sin argumentos
*/

// esto todo lo anterior en uno solo
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private String brand;
}
