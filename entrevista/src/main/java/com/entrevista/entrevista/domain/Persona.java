package com.entrevista.entrevista.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre",nullable = false)
	private String nombre;

	@Column(unique = true)
	private String email;

	private Integer edad;

	@Column(unique = true)
	private String dni;

}
