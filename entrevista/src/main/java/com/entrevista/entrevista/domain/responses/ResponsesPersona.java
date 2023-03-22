package com.entrevista.entrevista.domain.responses;

import com.entrevista.entrevista.domain.Persona;
import lombok.*;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsesPersona {
	private List<Persona> personas;
}
