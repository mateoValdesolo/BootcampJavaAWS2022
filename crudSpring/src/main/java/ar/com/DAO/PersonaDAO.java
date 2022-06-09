package ar.com.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.bean.Persona;

@Repository
public class PersonaDAO {
	/*
	 * PersonaDAO se encarga de manejar los Beans.
	 */

	private File getFile() {
		URI uri = null;
		try {
			uri = new URI(this.getClass().getResource("/personas.txt").toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new File(uri);
	}
	
	/** Retorna una Lista con todas las Personas agregadas hasta el momento.
	 * @return
	 * @throws IOException
	 */
	public List<Persona> getPersonas() throws IOException {
		

		List<Persona> personas = new ArrayList<Persona>();

		String linea = "";
		String[] atributos;

		BufferedReader buffer = new BufferedReader(new FileReader(this.getFile()));

		linea = buffer.readLine();
		while (linea != null) {
			
			atributos = linea.split(";");
			personas.add(Persona.builder()
								.nombre(atributos[0])
								.apellido(atributos[1])
								.dni(atributos[2])
								.nacimiento(atributos[3])
								.profesion(atributos[4])
								.build());
			
			linea = buffer.readLine();
		}

		buffer.close();

		return personas;
	}

	/** 
	 * Metodo que agrega y retorna la Persona recibida por parametro.
	 * @param per
	 * @return
	 * @throws Exception
	 */
	public Persona agregarPersona(Persona per) throws Exception {
		
		
		List<Persona> personas = getPersonas();
		
		Persona exists = personas.stream()
								 .filter(x -> x.getDni().equals(per.getDni()))
								 .findFirst()
								 .orElse(null);

		// Si la Persona no existe la agrega.
		if (exists == null) {
			// Agrego la persona a la lista
			personas.add(per);

			refrescarLista(personas);
		}

		return per;
	}

	/** Metodo que elimina la Persona con el DNI pasado por parametro.
	 * @param dni
	 * @throws Exception
	 */
	public void eliminarPersona(String dni) throws Exception {
		
		List<Persona> personas = getPersonas();
		personas = personas.stream()
						   .filter(x -> !x.getDni().equals(dni))
						   .collect(Collectors.toList());

		refrescarLista(personas);
	}

	/** Metodo que encuentra y retorna la Persona con el DNI pasado por parametro.
	 * @param dni
	 * @return
	 * @throws RuntimeException
	 * @throws IOException
	 */
	public Persona encontrarPersona(String dni) throws RuntimeException, IOException {
		
		return getPersonas().stream()
							.filter(x -> x.getDni().equals(dni))
							.findAny()
							.orElseThrow(() -> new RuntimeException("Persona No Existe"));
	}

	/** Metodo que agrega a la Persona editada y la retorna.
	 * @param per
	 * @return
	 * @throws Exception
	 */
	public Persona editar(Persona per) throws Exception {
		
		// Quito la persona con el DNI de la lista.
		List<Persona> personas = getPersonas();
		personas = personas.stream()
						   .filter(x -> !x.getDni().equals(per.getDni()))
						   .collect(Collectors.toList());

		// Agrego a la persona.
		personas.add(per);

		refrescarLista(personas);
		
		return per;
	}
	
	public void refrescarLista(List<Persona> personas) throws Exception{
		/*
		 * FileWriter utiliza el parametro append con el valor default en false, lo que quiere decir 
		 * que por defecto sobreescribe el archivo
		 */
		BufferedWriter buff = new BufferedWriter(new FileWriter(this.getFile()));
		        
		for(Persona per: personas) {
			  buff.write(per.getNombre() + "; ");
			  buff.write(per.getApellido() + "; ");
			  buff.write(per.getDni() + "; ");
			  buff.write(per.getNacimiento() + "; ");
			  buff.write(per.getProfesion());
			  buff.newLine();
		}
		        
		buff.close();
	}

}