package ar.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.beans.Persona;
import ar.com.exceptions.BOException;
import ar.com.exceptions.DAOException;
import ar.com.repository.PersonaDao;

@Service
public class PersonaBoImpl implements PersonaBo {

	@Autowired
	private PersonaDao perDao;

	@Override
	public void agregarPersona(Persona per) throws BOException {
		try {
			perDao.agregarPersona(per);
		} catch (DAOException e) {
			throw new BOException(e);
		}
	}

	@Override
	public List<Persona> listarPersonas() throws BOException {
		try {
			return perDao.listarPersonas();
		} catch (DAOException e) {
			throw new BOException(e);
		}
	}

	@Override
	public Persona obtenerPersonaPorDni(String dni) throws BOException {
		try {
			return perDao.obtenerPersonaPorDni(dni);
		} catch (DAOException e) {
			throw new BOException(e);
		}
	}

	@Override
	public void modificarPersona(Persona per) throws BOException {
		try {
			perDao.modificarPersona(per);
		} catch (DAOException e) {
			throw new BOException(e);
		}
	}

	@Override
	public void eliminarPersona(String dni) throws BOException {
		try {
			perDao.eliminarPersona(dni);
		} catch (DAOException e) {
			throw new BOException(e);
		}
	}

}
