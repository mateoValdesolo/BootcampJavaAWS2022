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

	public boolean agregarPersona(Persona per) {
		return perDao.agregarPersona(per);
	}

	public void eliminarPersona(String dni) {
		perDao.eliminarPersona(dni);
	}

	public Persona encontrarPersona(String dni) {
		return perDao.encontrarPersona(dni);
	}

	public boolean editar(Persona per) {
		return perDao.editar(per);
	}

} 