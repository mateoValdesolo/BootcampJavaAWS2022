package ar.com.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ar.com.beans.Persona;
import ar.com.exceptions.DAOException;
import ar.com.repository.mappers.PersonaMapper;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	private final Logger log = LogManager.getLogger(PersonaDao.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void agregarPersona(Persona per) throws DAOException {

		log.info("agregarPersona [ {} ]", per);

		try {
			String query = "INSERT INTO persona (nombre, apellido, dni, fechaNacimiento, profesion) VALUES (:nombre, :apellido, :dni, :fechaNacimiento, :profesion)";

			MapSqlParameterSource mapParameters = new MapSqlParameterSource();
			mapParameters.addValue("nombre", per.getNombre()).addValue("apellido", per.getApellido())
					.addValue("dni", per.getDni()).addValue("fechaNacimiento", per.getNacimiento())
					.addValue("profesion", per.getProfesion());

			jdbcTemplate.update(query, mapParameters);

		} catch (Throwable e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Persona> listarPersonas() throws DAOException {

		log.info("listarPersonas []");

		try {
			List<Persona> list = jdbcTemplate.query("SELECT * FROM persona;", new PersonaMapper());
			return list;
		} catch (Throwable e) {
			throw new DAOException(e);
		}
	}

	@Override
	public Persona obtenerPersonaPorDni(String dni) throws DAOException {
		log.info("obtenerPersonaPorDni [ {} ]", dni);

		try {
			String query = "SELECT * FROM persona WHERE dni = :dniPersona";

			MapSqlParameterSource mapParameters = new MapSqlParameterSource();
			mapParameters.addValue("dniPersona", dni);

			return jdbcTemplate.queryForObject(query, mapParameters, new PersonaMapper());

		} catch (Throwable e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void modificarPersona(Persona per) throws DAOException {
		log.info("modificarPersona [ {} ]", per);

		try {
			String query = "UPDATE persona SET nombre = :nombre, apellido = :apellido, fechaNacimiento = :fechaNacimiento, profesion = :profesion WHERE dni = :dni";

			MapSqlParameterSource mapParameters = new MapSqlParameterSource();
			mapParameters.addValue("nombre", per.getNombre());
			mapParameters.addValue("apellido", per.getApellido());
			mapParameters.addValue("dni", per.getDni());
			mapParameters.addValue("fechaNacimiento", per.getNacimiento());
			mapParameters.addValue("profesion", per.getProfesion());

			jdbcTemplate.update(query, mapParameters);

		} catch (Throwable e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void eliminarPersona(String dni) throws DAOException {
		log.info("eliminarPersona [ {} ]", dni);

		try {
			String query = "DELETE FROM persona WHERE dni = :dniPersona";

			MapSqlParameterSource mapParameters = new MapSqlParameterSource();
			mapParameters.addValue("dniPersona", dni);

			jdbcTemplate.update(query, mapParameters);

		} catch (Throwable e) {
			throw new DAOException(e);
		}
	}
}
