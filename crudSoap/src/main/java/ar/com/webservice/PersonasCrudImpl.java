package ar.com.webservice;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.entity.Persona;
import ar.com.exceptions.PersonaNotFoundException;
import ar.com.exceptions.PersonaRepetidaException;
import ar.com.service.PersonaBo;

@WebService
public class PersonasCrudImpl implements PersonasCrud {

	@Autowired
	private PersonaBo perBo;

	@Override
	public boolean agregar(Persona per) throws PersonaRepetidaException {
		if (perBo.existePersona(per.getDni())) {
			throw new PersonaRepetidaException();
		}
		return perBo.agregarPersona(per);
	}

	@Override
	public Persona obtenerPorDni(String dni) throws PersonaNotFoundException {
		if (!perBo.existePersona(dni)) {
			throw new PersonaNotFoundException();
		}
		return perBo.obtenerPersonaPorDni(dni);
	}

	@Override
	public boolean eliminar(String dni) throws PersonaNotFoundException {
		if (!perBo.existePersona(dni)) {
			throw new PersonaNotFoundException();
		}
		return perBo.eliminarPersona(dni);
	}

	@Override
	public boolean modificar(Persona per) throws PersonaNotFoundException {
		if (!perBo.existePersona(per.getDni())) {
			throw new PersonaNotFoundException();
		}
		return perBo.modificarPersona(per);
	}

	@Override
	public List<Persona> listar() {
		return perBo.listarPersonas();
	}

}
