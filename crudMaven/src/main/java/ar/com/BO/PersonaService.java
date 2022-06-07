package ar.com.BO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import ar.com.DAO.PersonaDAO;
import ar.com.bean.Persona;

public class PersonaService {
	/*
	 * PersonaService o PersonaBO. Es la clase que accede a la fuente donde estan
	 * almacenados los datos para obtener y almacenar datos. Usa el Patron de
	 * Disenio Singleton.
	 */

	private static PersonaService instance = null;
	private PersonaDAO perDao;

	private PersonaService() {
		perDao = new PersonaDAO();
	}

	public static PersonaService getInstance() {
		/*
		 * if(instance == null) { instance = new PersonaService(); } return instance;
		 */
		instance = Optional.ofNullable(instance).orElse(new PersonaService());
		return instance;
	}

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