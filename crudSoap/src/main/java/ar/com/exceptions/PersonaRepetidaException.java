package ar.com.exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name = "PersonaRepetida")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonaRepetidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 927759210745518278L;

	public PersonaRepetidaException() {
		this("La Persona ya existe!!!");
	}

	public PersonaRepetidaException(String message) {
		super(message);
	}
}
