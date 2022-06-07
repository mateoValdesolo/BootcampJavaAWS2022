package clase4;

/**
 * @author Mateo Valdesolo
 *
 */
public class Alumno {

	private int id, edad;
	private String dni, nombre, apellido, curso;
	private double nota;

	public Alumno(String dni, String nombre, String apellido, String curso, int id, int edad, double nota) {
		this.id = id;
		this.edad = edad;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public int getEdad() {
		return edad;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCurso() {
		return curso;
	}

	public double getNota() {
		return nota;
	}

}
