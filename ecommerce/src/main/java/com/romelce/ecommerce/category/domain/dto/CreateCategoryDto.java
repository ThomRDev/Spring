package com.romelce.ecommerce.category.domain.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CreateCategoryDto {
	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede estar vacio")
	@Length(min = 2,message = "El nombre minimo es de dos caracteres")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "El nombre solo puede contener letras")
	private String name;

	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonAnySetter
	public void handleUnknownField(String key, Object value) {
		throw new IllegalArgumentException("Campo desconocido: " + key);
	}
}
