package ar.com.crudSpringBData.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO")
	private String apellido;

	@Id
	@Column(name = "DNI")
	private String dni;

	@Column(name = "FECHANACIMIENTO")
	private String nacimiento;

	@Column(name = "PROFESION")
	private String profesion;

}