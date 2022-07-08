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

import ar.com.model.ListaPersonas;
import ar.com.model.Persona;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Listar
		List<Persona> list = new ArrayList<>();

		Response response = getTarget().request(MediaType.APPLICATION_JSON).get();

		try {
			if (response.getStatus() == HttpURLConnection.HTTP_OK) {
				ListaPersonas listaPer = response.readEntity(ListaPersonas.class);

				list.addAll(listaPer.getList());
			}
		} finally {
			response.close();
		}

		for (Persona persona : list) {
			System.out.println(persona.getDni());
		}

		// Buscar Por Dni

		Response busc = getTarget().path("42968925").request(MediaType.APPLICATION_JSON).get();
		Persona per = new Persona();

		try {
			if (busc.getStatus() == HttpURLConnection.HTTP_OK) {
				per = busc.readEntity(Persona.class);

			}
		} finally {
			busc.close();
		}
		System.out.println(per.getApellido());

		// Agregar

		/*
		 * Persona p = new Persona("1", "1", "1", "11-11-1111", "1");
		 * 
		 * Response agre =
		 * getTarget().request(MediaType.APPLICATION_JSON).post(Entity.json(p)); try {
		 * if (agre.getStatus() == HttpURLConnection.HTTP_OK) {
		 * System.out.println(agre.readEntity(String.class)); } } finally {
		 * agre.close(); }
		 */

		// Eliminar
		/**
		 * Response elim =
		 * getTarget().path("1").request(MediaType.APPLICATION_JSON).delete();
		 * 
		 * try { if (elim.getStatus() == HttpURLConnection.HTTP_OK) {
		 * System.out.println(elim.readEntity(String.class));
		 * 
		 * } } finally { elim.close(); }
		 */

		// modificas

		Persona p = new Persona("2", "2", "1", "11-11-2222", "2");

		Response modi = getTarget().request(MediaType.APPLICATION_JSON).put(Entity.json(p));
		try {
			if (modi.getStatus() == HttpURLConnection.HTTP_OK) {
				System.out.println(modi.readEntity(String.class));
			}
		} finally {
			modi.close();
		}

	}

	private static WebTarget getTarget() {
		Client client = ClientBuilder.newClient();

		return client.target("http://localhost:8080/crudRest/v1.0/personas");

	}

}
