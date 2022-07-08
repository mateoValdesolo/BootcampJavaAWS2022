package ar.com.service;

import java.util.List;

import ar.com.beans.Persona;
import ar.com.exceptions.BOException;

public interface PersonaBo {
	
	List<Persona> listarPersonas() throws BOException;
	
	void agregarPersona(Persona persona)throws BOException;
	
	void eliminarPersona(String dni) throws BOException;
	
	Persona obtenerPersonaPorDni (String dni) throws BOException;
	
	void modificarPersona(Persona persona) throws BOException;

}
