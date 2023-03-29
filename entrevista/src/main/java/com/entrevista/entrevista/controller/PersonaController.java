package com.entrevista.entrevista.controller;

import com.entrevista.entrevista.domain.Persona;
import com.entrevista.entrevista.domain.dto.CreatePersonDto;
import com.entrevista.entrevista.domain.dto.UpdatePersonDto;
import com.entrevista.entrevista.domain.responses.ResponsesPersona;
import com.entrevista.entrevista.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;


	@PostMapping
	public ResponseEntity<Map<String,Object>> crear(@RequestBody @Valid CreatePersonDto createPersonDto){
		this.personaService.crear(createPersonDto);
		Map<String,Object> response = new HashMap<>();
		response.put("ok",true);
		response.put("msg","Persona creada con exito");
		return ResponseEntity.status(200).body(response);
	}

	@GetMapping("/")
	public ResponseEntity<Object> listar(
			@RequestParam(required = false,name = "edad") Integer edad,
			@RequestParam(required = false,name = "dni") String dni
	){
		if(edad != null) {
			return ResponseEntity.status(200).body(this.personaService.filtrarPorEdad(edad));
		}
		if(dni != null) {
			return ResponseEntity.status(200).body(this.personaService.filtrarPorDni(dni));
		}
		return ResponseEntity.status(200).body(this.personaService.obtenerTodos());
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Persona> actualizar(@RequestBody @Valid UpdatePersonDto updatePersonDto,@PathVariable Long id){
//
//	}

}
