package ar.com.bo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ar.com.model.PersonaLocal;
import ar.com.webServices.personas.crud.service.PersonaNotFoundException;
import ar.com.webServices.personas.crud.service.PersonaRepetidaException;
import ar.com.webServices.personas.crud.service.PersonasCrud;
import ar.com.webServices.personas.crud.service.PersonasCrudImplService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Override
	public List<PersonaLocal> getPersonas() {

		PersonasCrudImplService webService = new PersonasCrudImplService();

		PersonasCrud service = webService.getPersonasCrudImplPort();

		return mapToList(service.listar());

	}

	@Override
	public boolean agregarPersona(PersonaLocal per) throws PersonaRepetidaException {
		PersonasCrudImplService webService = new PersonasCrudImplService();

		PersonasCrud service = webService.getPersonasCrudImplPort();

		return service.agregar(mapToPerson(per));
	}

	@Override
	public void eliminarPersona(String dni) throws PersonaNotFoundException {
		PersonasCrudImplService webService = new PersonasCrudImplService();

		PersonasCrud service = webService.getPersonasCrudImplPort();

		service.eliminar(dni);

	}

	@Override
	public PersonaLocal encontrarPersona(String dni) throws PersonaNotFoundException {
		PersonasCrudImplService webService = new PersonasCrudImplService();

		PersonasCrud service = webService.getPersonasCrudImplPort();

		return mapToPersonLocal(service.obtenerPorDni(dni));
	}

	@Override
	public boolean editar(PersonaLocal per) throws PersonaNotFoundException {
		PersonasCrudImplService webService = new PersonasCrudImplService();

		PersonasCrud service = webService.getPersonasCrudImplPort();
		
		return service.modificar(mapToPerson(per));
	}

	private List<PersonaLocal> mapToList(List<ar.com.webServices.personas.crud.service.Persona> personas) {
		return personas.stream().map(this::mapToPersonLocal).collect(Collectors.toList());
	}

	private PersonaLocal mapToPersonLocal(ar.com.webServices.personas.crud.service.Persona p) {
		return new PersonaLocal(p.getNombre(), p.getApellido(), p.getDni(), p.getNacimiento(), p.getProfesion());
	}

	private ar.com.webServices.personas.crud.service.Persona mapToPerson(PersonaLocal p) {
		ar.com.webServices.personas.crud.service.Persona persona = new ar.com.webServices.personas.crud.service.Persona();
		persona.setApellido(p.getApellido());
		persona.setNombre(p.getNombre());
		persona.setDni(p.getDni());
		persona.setNacimiento(p.getNacimiento());
		persona.setProfesion(p.getProfesion());
		return persona;
	}

}