package ar.com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@XmlRootElement(name = "persona")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Persona {

	private String nombre;

	private String apellido;

	private String dni;

	private String nacimiento;

	private String profesion;

	// Constructores

	public Persona(String nombre, String apellido, String dni, String nacimiento, String profesion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.profesion = profesion;
	}

	public Persona() {
		super();
	}

	// Setters

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	// Getters

	// @JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	// @JsonProperty("apellido")
	public String getApellido() {
		return apellido;
	}

	// @JsonProperty("dni")
	public String getDni() {
		return dni;
	}

	// @JsonProperty("nacimiento")
	public String getNacimiento() {
		return nacimiento;
	}

	// @JsonProperty("profesion")
	public String getProfesion() {
		return profesion;
	}

}
