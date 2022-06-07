package ar.com.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString

public class Persona {

	private String nombre, apellido, dni, nacimiento, profesion;

}
