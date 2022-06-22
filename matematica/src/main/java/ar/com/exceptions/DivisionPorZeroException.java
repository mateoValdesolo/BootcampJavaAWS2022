package ar.com.exceptions;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;
import javax.xml.bind.annotation.XmlAccessType;

@WebFault(name = "DivisionPorCero")
@XmlAccessorType(XmlAccessType.FIELD)
public class DivisionPorZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	public DivisionPorZeroException() {
		this("Error, division por cero");
	}

	public DivisionPorZeroException(String message) {
		super(message);
	}

}
