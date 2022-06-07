package clase4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Mateo Valdesolo
 *
 */
public class EjerciciosClase4 {
	public static void main(String[] args) {
		// Prueba Ejercicios Thread
		/*
		 * ThreadNumOne t1 = new ThreadNumOne(); t1.start();
		 */
		
		ThreadNumTwo evenThread = new ThreadNumTwo('E');
		ThreadNumTwo oddThread = new ThreadNumTwo('O');
		
		evenThread.start();
		oddThread.start();

		// Prueba Ejercicios Streams & Lambdas
		int cantAlumnos = 17;
		Random r = new Random();
		List<Alumno> alumnos = new ArrayList<Alumno>();

		// Agrego los alumnos a la lista.
		for (int i = 0; i < cantAlumnos; i++) {
			Alumno alum = new Alumno(Integer.toString(42900000 + r.nextInt(99999)), randomName(), randomSurname(), Integer.toString(r.nextInt(3) + 1), i, randomAge(), randomMark());
			alumnos.add(alum);
		}

		// Muestro a todos los Alumnos de la Lista.
		System.out.println("--------------- TODOS LOS ALUMNOS ---------------");
		
		alumnos.stream()
				.forEach(alumno -> data(alumno));
		
		// Muestro todos los Alumnos de la Lista ordenados de menor a mayor por edad.
		System.out.println("--------------- ALUMNOS DE MENOR A MAYOR POR EDAD ---------------");
		
		alumnos.stream()
				.sorted(Comparator.comparing(Alumno::getEdad))
				.forEach(alumno -> data(alumno));
		
		// Muestro aquellos alumnos cuyo nombre empieza con un caracter dado.
		char charName = 'D';
		System.out.println("--------------- ALUMNOS CUYO NOMBRE EMPIEZA CON "+ charName +" ---------------");
		
		alumnos.stream()
				.filter(alum -> Objects.equals(charName, alum.getNombre().charAt(0)))
				.forEach(alumno -> data(alumno));
		
		// Suma la edad de todos los alumnos.
		int sumAge = alumnos.stream()
							.mapToInt(alumno -> alumno.getEdad())
							.sum();
		
		System.out.println("--------------- SUMA DE LAS EDADES DE LOS ALUMNOS "+ sumAge +" ---------------");
		
		// Mapa donde la clave es la nota y el valor es una lista de alumnos que tienen esa nota.
		Map<Double,List<Alumno>> map = new HashMap<>();
		
		map = alumnos.stream()
					.collect(Collectors.groupingBy(Alumno::getNota));

		// Muestro los alumnos que tienen la misma nota.
		System.out.println("--------------- ALUMNOS CON LA MISMA NOTA ---------------");

		map.forEach((key, value) -> {
			System.out.println("Nota: " + key);
			value.stream().forEach(alumno -> data(alumno));
		});

	}
	
	public static void data(Alumno alumno) {
		/**
		 * Imprime los datos del alumno.
		 * */
		System.out.println("-ID: " + alumno.getId() 
		+ " -DNI: " + alumno.getDni()
		+ " -Nombre: " + alumno.getNombre() 
		+ " -Apellido: " + alumno.getApellido()
		+ " -Edad: " + alumno.getEdad()
		+ " -Curso: " + alumno.getCurso()
		+ " -Nota: " + alumno.getNota());
	}

	public static String randomName() {
		// Retorna un nombre aleatorio del arreglo
		Random r = new Random();
		String names[] = { "Maria", "Carmen", "Manuel", "David", "Jose", "Luis", "Javier", "Laura", "Isabel", "Ana",
				"Olivia", "Isabela", "Santiago", "Daniel", "Emiliano", "Matias", "Dario" };
		return names[r.nextInt(16)];
	}

	public static String randomSurname() {
		// Retorna un apellido aleatorio del arreglo
		Random r = new Random();
		String names[] = { "Gonzalez", "Rodriguez", "Fernandez", "Diaz", "Perez", "Gomez", "Lucero", "Sosa", "Quiroga",
				"Martinez", "Sanchez", "Silva", "Morales", "Sepulveda", "Contreras", "Rojas" };
		return names[r.nextInt(16)];
	}

	public static int randomAge() {
		// Retorna un numero aleatorio entre 18 y 25, inclusive ambos numeros.
		Random r = new Random();
		return r.nextInt(8) + 18;
	}

	public static double randomMark() {
		// Retorna un numero aleatorio entre 0 y 10, inclusive ambos numeros.
		Random r = new Random();
		return Math.round(10 * r.nextDouble() * 10.0) / 10.0; // Redondeo asi me quedan 2 cifras decimales.
	}

}
