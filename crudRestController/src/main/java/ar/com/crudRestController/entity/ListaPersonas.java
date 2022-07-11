package ar.com.crudRestController.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListaPersonas {

	@JsonProperty("listaPersonas")
	private List<Persona> list;

	public ListaPersonas() {
		
	}

	public ListaPersonas(List<Persona> list) {
		super();
		this.list = list;
	}

	public List<Persona> getList() {
		return list;
	}

	public void setList(List<Persona> list) {
		this.list = list;
	}

}
