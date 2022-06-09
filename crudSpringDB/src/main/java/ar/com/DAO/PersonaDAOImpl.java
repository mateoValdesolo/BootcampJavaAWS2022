package ar.com.DAO;

import java.sql.Connection;
import java.io.IOException;
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

import ar.com.bean.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	/*
	 * PersonaDAO se encarga de manejar los Beans.
	 */

	@Autowired
	JdbcTemplate statement;

	/**
	 * Retorna una Lista con todas las Personas agregadas hasta el momento.
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Persona> getPersonas() {

		List<Persona> list = statement.query("SELECT * FROM crud;", new RowMapper<Persona>() {

			@Override
			public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
				Persona per = new Persona();

				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setDni(rs.getString("dni"));
				per.setNacimiento(rs.getString("fecha_nac"));
				per.setProfesion(rs.getString("profesion"));

				return per;
			}

		});

		return list;
	}

	/**
	 * Metodo que agrega y retorna la Persona recibida por parametro.
	 * 
	 * @param per
	 * @return
	 * @throws Exception
	 */
	public boolean agregarPersona(Persona per) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO crud (nombre, apellido, dni, fecha_nac,profesion) VALUES(?,?,?,?,?)");

				statement.setString(1, null);
				statement.setString(2, per.getNombre());
				statement.setString(3, per.getApellido());
				statement.setString(4, per.getDni());
				statement.setString(5, per.getNacimiento());
				statement.setString(6, per.getProfesion());

				return statement;

			}
		});

		status = true;

		return status;
	}

	/**
	 * Metodo que elimina la Persona con el DNI pasado por parametro.
	 * 
	 * @param dni
	 * @throws Exception
	 */
	public boolean eliminarPersona(String dni) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement("DELETE FROM crud WHERE dni=?");

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
	 * @param dni
	 * @return
	 * @throws RuntimeException
	 * @throws IOException
	 */
	public Persona encontrarPersona(String dni) {

		Persona p = statement.queryForObject("SELECT * FROM crud WHERE dni =?", new Object[] { dni },
				new int[] { Types.VARCHAR }, new RowMapper<Persona>() {

					@Override
					public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
						Persona p = new Persona();

						p.setNombre(rs.getString("nombre"));
						p.setApellido(rs.getString("apellido"));
						p.setDni(rs.getString("dni"));
						p.setNacimiento(rs.getString("fecha_nac"));
						p.setProfesion(rs.getString("profesion"));

						return p;
					}

				});

		return p;
	}

	/**
	 * Metodo que agrega a la Persona editada y la retorna.
	 * 
	 * @param per
	 * @return
	 * @throws Exception
	 */
	public boolean editar(Persona per) {

		boolean status = false;

		statement.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(
						"UPDATE crud SET nombre=?, apellido=?, fechaNacimiento=?, profesion=? WHERE dni=?");

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

}