package ar.com.crudRestController.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.crudRestController.dao.PersonaDao;
import ar.com.crudRestController.entity.ListaPersonas;
import ar.com.crudRestController.entity.Persona;

@RestController
@RequestMapping("/personas/v1.0")
public class CrudRest {

	private final Logger log = LogManager.getLogger(CrudRest.class);

	@Autowired
	private PersonaDao perDao;

	@GetMapping
	public ResponseEntity<ListaPersonas> getPersonas() {

		log.info("Obteniendo Lista de Personas");

		ListaPersonas list = new ListaPersonas(perDao.findAll());

		return ResponseEntity.ok(list);
	}

	@RequestMapping(value = "{dni}")
	public ResponseEntity<Persona> obtenerPersonaPorDni(@PathVariable("dni") String dni) {

		log.info("Obteniendo persona con dni {}", dni);

		Optional<Persona> optUser = perDao.findById(dni);
		if (optUser.isPresent())
			return ResponseEntity.ok(optUser.get());
		else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping
	public ResponseEntity<Persona> agregar(@RequestBody Persona per) {

		log.info("Agregando persona");

		Persona nuevaPersona = perDao.save(per);
		return ResponseEntity.ok(nuevaPersona);

	}

	@DeleteMapping(value = "{dni}")
	public ResponseEntity<Void> eliminar(@PathVariable("dni") String dni) {

		log.info("Eliminando persona con dni {}", dni);

		perDao.deleteById(dni);
		return ResponseEntity.ok(null);

	}

	@PutMapping
	public ResponseEntity<Persona> actualizar(@RequestBody Persona per) {

		log.info("Actualizando persona con dni {}", per.getDni());

		Optional<Persona> optUser = perDao.findById(per.getDni());

		if (optUser.isPresent()) {

			Persona persona = optUser.get();
			persona.setNombre(per.getNombre());
			persona.setApellido(per.getApellido());
			persona.setDni(per.getDni());
			persona.setFechaNacimiento(per.getFechaNacimiento());
			persona.setProfesion(per.getProfesion());
			perDao.save(persona);
			return ResponseEntity.ok(persona);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
