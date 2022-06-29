package ar.com.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Persona {

	private String nombre, apellido, dni, nacimiento, profesion;

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

}