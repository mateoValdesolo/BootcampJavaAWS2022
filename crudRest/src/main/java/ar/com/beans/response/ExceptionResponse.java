package ar.com.beans.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@XmlRootElement(name = "ExceptionResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ExceptionResponse {

	private String httpCode;

	private String message;

	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
