package ar.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.entity.Persona;
import ar.com.repository.PersonaDao;

@Service
public class PersonaBoImpl implements PersonaBo {
	
	@Autowired
	private PersonaDao perDao;

	@Override
	public boolean agregarPersona(Persona per) {
		return perDao.agregarPersona(per);
	}

	@Override
	public List<Persona> listarPersonas() {
		return perDao.listarPersonas();
	}

	@Override
	public Persona obtenerPersonaPorDni(String dni) {
		return perDao.obtenerPersonaPorDni(dni);
	}

	@Override
	public boolean modificarPersona(Persona per) {
		return perDao.modificarPersona(per);
	}

	@Override
	public boolean eliminarPersona(String dni) {
		return perDao.eliminarPersona(dni);
	}

	@Override
	public boolean existePersona(String dni) {
		return perDao.existePersona(dni);
	}

}
