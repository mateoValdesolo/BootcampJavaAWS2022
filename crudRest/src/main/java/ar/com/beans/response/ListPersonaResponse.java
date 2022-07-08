package ar.com.beans.response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import ar.com.beans.Persona;

@XmlRootElement(name = "PersonaListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ListPersonaResponse {

	private int statusCode;

	@XmlElementWrapper(name = "personas")
	@XmlElement(name = "persona")
	private List<Persona> list;

	public ListPersonaResponse() {
		this(new ArrayList<Persona>());
	}

	public ListPersonaResponse(List<Persona> lista) {
		this(Status.OK.getStatusCode(), lista);
	}

	public ListPersonaResponse(int code, List<Persona> lista) {
		this.setStatusCode(code);
		this.setList(lista);
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
