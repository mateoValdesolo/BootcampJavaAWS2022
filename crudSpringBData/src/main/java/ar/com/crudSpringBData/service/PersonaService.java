package ar.com.crudSpringBData.service;

import java.util.List;

import ar.com.crudSpringBData.entity.Persona;

public interface PersonaService {

	List<Persona> getPersonas();

	void guardar(Persona usuario);

	Persona obtenerPorDni(String dni);

	void eliminarporDni(String dni);
}
