package com.romelce.ecommerce.product.domain.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Map;

@Data
public class CreateProductDto {


	@NotEmpty(message = "No puede estar vacio")
	@NotNull(message = "No puede ser nulo")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "El nombre solo puede contener letras")
	private String name;


	@NotNull(message = "No puede ser nulo")
	@DecimalMin(value = "0.0", message = "El precio no puede ser menor a 0")
	@Digits(integer = 10, fraction = 2, message = "El precio no puede tener más de 10 dígitos enteros y 2 decimales")
	private Double price;

	@NotNull(message = "No puede ser nulo")
	@Min(value = 0, message = "El stock no puede ser menor a 0")
	private Integer stock;


	@NotNull(message = "No puede ser nulo")
	private Long category_id;

	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonAnySetter
	public void handleUnknownField(String key, Object value) {
		throw new IllegalArgumentException("Campo desconocido: " + key);
	}
}
