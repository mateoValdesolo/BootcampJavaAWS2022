package ar.com.exceptions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name = "PersonaNotFound")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonaNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 927759210745518278L;

	public PersonaNotFoundException() {
		this("La Persona no existe!!!");
	}

	public PersonaNotFoundException(String message) {
		super(message);
	}
}
