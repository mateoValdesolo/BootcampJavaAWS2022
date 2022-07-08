package ar.com.bo;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import ar.com.exceptions.PersonaNotFoundException;
import ar.com.exceptions.PersonaRepetidaException;
import ar.com.model.ListaPersonas;
import ar.com.model.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	private WebTarget getTarget() {
		Client client = ClientBuilder.newClient();

		return client.target("http://localhost:8080/crudRest/v1.0/personas");

	}

	@Override
	public List<Persona> getPersonas() {
		List<Persona> list = new ArrayList<>();
		Response response = this.getTarget().request(MediaType.APPLICATION_JSON).get();

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				ListaPersonas listaPer = response.readEntity(ListaPersonas.class);
				list.addAll(listaPer.getList());
			}
		} finally {
			response.close();
		}
		return list;
	}

	@Override
	public boolean agregarPersona(Persona per) throws PersonaRepetidaException {
		Response response = this.getTarget().request(MediaType.APPLICATION_JSON).post(Entity.json(per));
		boolean exito = false;

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				exito = true;
			}
		} finally {
			response.close();
		}

		return exito;
	}

	@Override
	public boolean eliminarPersona(String dni) throws PersonaNotFoundException {
		Response response = this.getTarget().path(dni).request(MediaType.APPLICATION_JSON).delete();
		boolean exito = false;

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				exito = true;
			}
		} finally {
			response.close();
		}
		return exito;
	}

	@Override
	public Persona encontrarPersona(String dni) throws PersonaNotFoundException {
		Persona per = new Persona();
		Response response = this.getTarget().path(dni).request(MediaType.APPLICATION_JSON).get();

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				per = response.readEntity(Persona.class);
			}
		} finally {
			response.close();
		}
		return per;
	}

	@Override
	public boolean editar(Persona per) throws PersonaNotFoundException {
		Response response = this.getTarget().request(MediaType.APPLICATION_JSON).put(Entity.json(per));
		boolean exito = false;

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				exito = true;
			}
		} finally {
			response.close();
		}

		return exito;
	}

}