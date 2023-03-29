package com.synopsis.dbdemo.domain.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private String name;

	private Double price;

	private Integer stock;
}
