package ar.com.repository;

import java.util.List;

import ar.com.entity.Persona;

public interface PersonaDao {

	public boolean agregarPersona(Persona per);

	public List<Persona> listarPersonas();

	public Persona obtenerPersonaPorDni(String dni);

	public boolean modificarPersona(Persona per);

	public boolean eliminarPersona(String dni);
	
	public boolean existePersona(String dni);	

}