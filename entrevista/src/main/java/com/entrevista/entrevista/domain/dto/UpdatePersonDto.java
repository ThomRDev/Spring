package com.entrevista.entrevista.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePersonDto {
	@NotEmpty(message = "el campo nombre no esta vacio")
	@Length(min = 2,message = "El nombre debe de tener como minimo dos caracteres")
	private String nombre;

	@NotEmpty(message = "el campo email no esta vacio")
	@Email(message = "Debe de ser un email valido")
	private String email;

	@Min(value = 17,message = "Debe de tener como minimo 17 años")
	private Integer edad;

	@Length(min = 8,max = 8,message = "Debe de tener 8 caracteres")
	private String dni;
}
