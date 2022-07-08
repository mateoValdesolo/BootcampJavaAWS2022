package ar.com.repository.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.beans.Persona;

public class PersonaMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona per = new Persona();

		per.setNombre(rs.getString("nombre"));
		per.setApellido(rs.getString("apellido"));
		per.setDni(rs.getString("dni"));
		per.setNacimiento(rs.getString("fechaNacimiento"));
		per.setProfesion(rs.getString("profesion"));

		return per;
	}

}
