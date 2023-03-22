package com.entrevista.entrevista.service;

import com.entrevista.entrevista.domain.Persona;
import com.entrevista.entrevista.domain.dto.CreatePersonDto;
import com.entrevista.entrevista.domain.responses.ResponsesPersona;

public interface PersonaService {
	void crear(CreatePersonDto createPersonDto);

	ResponsesPersona obtenerTodos();

	Persona filtrarPorDni(String dni);

	ResponsesPersona filtrarPorEdad(Integer edad);

	Persona actualizar(Long id);

}
