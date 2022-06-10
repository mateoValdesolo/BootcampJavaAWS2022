package ar.com.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.DAO.PersonaDAOImpl;
import ar.com.bean.Persona;

@Service
public class PersonaService {
	/*
	 * PersonaService o PersonaBO. Es la clase que accede a la fuente donde estan
	 * almacenados los datos para obtener y almacenar datos.
	 */

	@Autowired
	private PersonaDAOImpl perDao;

	public List<Persona> getPersonas() {
		return perDao.getPersonas();
	}

	public void agregarPersona(Persona per) {
		perDao.agregarPersona(per);
	}

	public void eliminarPersona(String dni) {
		perDao.eliminarPersona(dni);
	}

	public Persona encontrarPersona(String dni) {
		return perDao.encontrarPersona(dni);
	}

	public void editar(Persona per) {
		perDao.editar(per);
	}

}