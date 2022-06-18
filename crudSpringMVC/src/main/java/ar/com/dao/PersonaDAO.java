package ar.com.dao;

import java.util.List;

import ar.com.model.Persona;

public interface PersonaDAO {
	
	List<Persona> getPersonas();

	boolean agregarPersona(Persona persona);

	boolean eliminarPersona(String dni);

	Persona encontrarPersona(String dni);

	boolean editar(Persona persona);
}
