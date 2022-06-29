package ar.com.entityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.entity.Persona;

public class PersonaMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona p = new Persona();

		p.setNombre(rs.getString("nombre"));
		p.setApellido(rs.getString("apellido"));
		p.setDni(rs.getString("dni"));
		p.setNacimiento(rs.getString("fechaNacimiento"));
		p.setProfesion(rs.getString("profesion"));

		return p;
	}

}