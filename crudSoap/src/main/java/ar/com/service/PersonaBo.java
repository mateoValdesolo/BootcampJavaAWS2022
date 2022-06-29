package ar.com.service;

import java.util.List;

import ar.com.entity.Persona;

public interface PersonaBo {
	
	public boolean agregarPersona(Persona per);

	public List<Persona> listarPersonas();

	public Persona obtenerPersonaPorDni(String dni);

	public boolean modificarPersona(Persona per);

	public boolean eliminarPersona(String dni);
	
	public boolean existePersona(String dni);	

}
