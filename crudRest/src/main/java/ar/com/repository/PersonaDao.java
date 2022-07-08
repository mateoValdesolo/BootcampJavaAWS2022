package ar.com.repository;

import java.util.List;

import ar.com.beans.Persona;
import ar.com.exceptions.DAOException;

public interface PersonaDao {

	public void agregarPersona(Persona per) throws DAOException;

	public List<Persona> listarPersonas() throws DAOException;

	public Persona obtenerPersonaPorDni(String dni) throws DAOException;

	public void modificarPersona(Persona per) throws DAOException;

	public void eliminarPersona(String dni) throws DAOException;

}