package ar.com.DAO;

import java.util.List;

import ar.com.bean.Persona;

public interface PersonaDAO {
	
	List<Persona> getPersonas();

	void agregarPersona(Persona persona);

	void eliminarPersona(String dni);

	Persona encontrarPersona(String dni);

	void editar(Persona persona);
}
