package com.entrevista.entrevista.service.impl;

import com.entrevista.entrevista.Errors.PersonaErrorException;
import com.entrevista.entrevista.domain.Persona;
import com.entrevista.entrevista.domain.dto.CreatePersonDto;
import com.entrevista.entrevista.domain.responses.ResponsesPersona;
import com.entrevista.entrevista.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void crear(CreatePersonDto createPersonDto) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREATE_PERSONA");

		MapSqlParameterSource inParams = new MapSqlParameterSource();
		inParams.addValue("nombre", createPersonDto.getNombre());
		inParams.addValue("email", createPersonDto.getEmail());
		inParams.addValue("edad", createPersonDto.getEdad());
		inParams.addValue("dni", createPersonDto.getDni());

		try {
			jdbcCall.execute(inParams);
		} catch (DataAccessException e) {
			throw new PersonaErrorException("Error al crear una persona => "+e.getMessage());
		}

	}

	@Override
	public ResponsesPersona obtenerTodos() {
		String sql = "SELECT * FROM personas";
		List<Persona> personas = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			Persona persona = Persona.builder()
					.dni(resultSet.getString("dni"))
					.id(resultSet.getLong("id"))
					.edad(resultSet.getInt("edad"))
					.email(resultSet.getString("email"))
					.nombre(resultSet.getString("nombre"))
					.build();
			return persona;
		});
		return ResponsesPersona.builder().personas(personas).build();
	}

	@Override
	public Persona filtrarPorDni(String dni) {
		String sql = "SELECT * FROM personas WHERE dni='"+dni+"'";
		try {
			return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
				Persona persona = Persona.builder()
						.dni(resultSet.getString("dni"))
						.id(resultSet.getLong("id"))
						.edad(resultSet.getInt("edad"))
						.email(resultSet.getString("email"))
						.nombre(resultSet.getString("nombre"))
						.build();
				return persona;
			});

		}catch (EmptyResultDataAccessException e){
			throw new PersonaErrorException("No se encontro a la persona con el dni "+dni);
		}
	}

	@Override
	public ResponsesPersona filtrarPorEdad(Integer edad) {
		String sql = "SELECT * FROM personas WHERE edad="+edad;
		List<Persona> edadesComunes = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			Persona persona = Persona.builder()
					.dni(resultSet.getString("dni"))
					.id(resultSet.getLong("id"))
					.edad(resultSet.getInt("edad"))
					.email(resultSet.getString("email"))
					.nombre(resultSet.getString("nombre"))
					.build();
			return persona;
		});
//		List<Persona> edadesComunes = this.personaRepository.findByEdad(edad);
		return ResponsesPersona.builder().personas(edadesComunes).build();
	}

	@Override
	public Persona actualizar(Long id) {
		return null;
	}
}
