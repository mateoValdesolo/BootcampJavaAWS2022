package ar.com.bo;

import java.util.List;

import ar.com.model.PersonaLocal;
import ar.com.webServices.personas.crud.service.PersonaNotFoundException;
import ar.com.webServices.personas.crud.service.PersonaRepetidaException;

public interface PersonaService {

	public List<PersonaLocal> getPersonas();

	public boolean agregarPersona(PersonaLocal per) throws PersonaRepetidaException;

	public void eliminarPersona(String dni) throws PersonaNotFoundException;

	public PersonaLocal encontrarPersona(String dni) throws PersonaNotFoundException;

	public boolean editar(PersonaLocal per) throws PersonaNotFoundException;
	
}
