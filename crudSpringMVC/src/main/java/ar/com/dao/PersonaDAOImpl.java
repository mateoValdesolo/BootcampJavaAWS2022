package ar.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ar.com.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {

	@Autowired
	private JdbcTemplate statement;

	/*
	 * public PersonaDAOImpl(DataSource dataSource) { statement = new
	 * JdbcTemplate(dataSource); }
	 */

	public List<Persona> getPersonas() {

		List<Persona> list = statement.query("SELECT * FROM persona;", new RowMapper<Persona>() {

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

		});

		return list;
	}

	/**
	 * Metodo que agrega la Persona recibida por parametro.
	 */
	public boolean agregarPersona(Persona per) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO persona (nombre, apellido, dni, fechaNacimiento,profesion) VALUES(?,?,?,?,?)");

				statement.setString(1, per.getNombre());
				statement.setString(2, per.getApellido());
				statement.setString(3, per.getDni());
				statement.setString(4, per.getNacimiento());
				statement.setString(5, per.getProfesion());

				return statement;

			}
		});

		status = true;

		return status;
	}

	/**
	 * Metodo que elimina la Persona con el DNI pasado por parametro.
	 */
	public boolean eliminarPersona(String dni) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement("DELETE FROM persona WHERE dni=?");

				statement.setString(1, dni);

				return statement;

			}
		});

		status = true;

		return status;
	}

	/**
	 * Metodo que encuentra y retorna la Persona con el DNI pasado por parametro.
	 * 
	 */
	public Persona encontrarPersona(String dni) {

		Persona p = statement.queryForObject("SELECT * FROM persona WHERE dni =?", new Object[] { dni },
				new int[] { Types.VARCHAR }, new RowMapper<Persona>() {

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

				});

		return p;
	}

	/**
	 * Metodo que agrega a la Persona editada y la retorna.
	 */
	public boolean editar(Persona per) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(
						"UPDATE persona SET nombre=?, apellido=?, fechaNacimiento=?, profesion=? WHERE dni=?");

				statement.setString(1, per.getNombre());
				statement.setString(2, per.getApellido());
				statement.setString(3, per.getNacimiento());
				statement.setString(4, per.getProfesion());
				statement.setString(5, per.getDni());

				return statement;

			}
		});

		status = true;

		return status;
	}

}