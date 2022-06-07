package ar.com.BO;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.DAO.PersonaDAO;
import ar.com.bean.Persona;

@Service
public class PersonaService {
	/*
	 * PersonaService o PersonaBO. Es la clase que accede a la fuente donde estan
	 * almacenados los datos para obtener y almacenar datos.
	 */
	
	@Autowired
	private PersonaDAO perDao;

	public List<Persona> getPersonas() throws IOException {
		return perDao.getPersonas();
	}

	public Persona agregarPersona(Persona per) throws Exception {
		return perDao.agregarPersona(per);
	}

	public void eliminarPersona(String dni) throws Exception {
		perDao.eliminarPersona(dni);
	}

	public Persona encontrarPersona(String dni) throws RuntimeException, IOException {
		return perDao.encontrarPersona(dni);
	}

	public Persona editar(Persona per) throws Exception {
		return perDao.editar(per);
	}

}