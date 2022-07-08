package ar.com.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ListaPersonas {

private int statusCode;
	
	private List<Persona> list;
	
	public ListaPersonas() {
		this(new ArrayList<Persona>());
	}

	public ListaPersonas(List<Persona> l) {
		this(200, l);
	}	
	
	public ListaPersonas(int code, List<Persona> l) {
		this.setStatusCode(code);
		this.setList(l);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Persona> getList() {
		return list;
	}

	public void setList(List<Persona> list) {
		this.list = list;
	}
	
}
