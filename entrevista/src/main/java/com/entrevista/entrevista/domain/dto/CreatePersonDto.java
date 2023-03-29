package com.entrevista.entrevista.domain.dto;

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
public class CreatePersonDto {

	@NotNull(message = "el campo nombre no ser nulo")
	@NotEmpty(message = "el campo nombre no esta vacio")
	@Length(min = 2,message = "El nombre debe de tener como minimo dos caracteres")
	private String nombre;


	@NotNull(message = "el campo email no ser nulo")
	@NotEmpty(message = "el campo email no esta vacio")
	@Email(message = "Debe de ser un email valido")
	private String email;

	@Min(value = 17,message = "Debe de tener como minimo 17 años")
	@NotNull(message = "el campo email no ser nulo")
	private Integer edad;

	@Length(min = 8,max = 8,message = "Debe de tener 8 caracteres")
	@NotNull(message = "el campo email no ser nulo")
	private String dni;
}
