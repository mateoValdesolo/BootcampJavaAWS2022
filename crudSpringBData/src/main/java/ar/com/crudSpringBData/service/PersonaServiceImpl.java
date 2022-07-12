package ar.com.crudSpringBData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.crudSpringBData.entity.Persona;
import ar.com.crudSpringBData.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository perRepo;

	public List<Persona> getPersonas() {

		return (List<Persona>) perRepo.findAll();
	}

	public void guardar(Persona per) {

		perRepo.save(per);
	}

	public Persona obtenerPorDni(String dni) {

		return perRepo.findById(dni).orElseThrow(() -> new RuntimeException("No encontramos usuario con Dni: " + dni));
	}

	@Override
	public void eliminarporDni(String dni) {

		perRepo.deleteById(dni);
	}

}
