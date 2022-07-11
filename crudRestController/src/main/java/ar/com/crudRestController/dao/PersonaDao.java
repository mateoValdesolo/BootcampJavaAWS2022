package ar.com.crudRestController.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.crudRestController.entity.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona, String> {

}
