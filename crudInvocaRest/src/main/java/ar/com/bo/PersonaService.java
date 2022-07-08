package ar.com.bo;

import java.util.List;

import ar.com.exceptions.PersonaNotFoundException;
import ar.com.exceptions.PersonaRepetidaException;
import ar.com.model.Persona;

public interface PersonaService {

	public List<Persona> getPersonas();

	public boolean agregarPersona(Persona per) throws PersonaRepetidaException;

	public boolean eliminarPersona(String dni) throws PersonaNotFoundException;

	public Persona encontrarPersona(String dni) throws PersonaNotFoundException;

	public boolean editar(Persona per) throws PersonaNotFoundException;
	
}
