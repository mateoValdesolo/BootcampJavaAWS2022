package ar.com.crudSpringBData.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.crudSpringBData.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, String> {

}
