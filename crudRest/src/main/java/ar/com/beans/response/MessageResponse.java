package ar.com.beans.response;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@XmlRootElement(name = "MessageResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MessageResponse {

	private int statusCode;

	private String statusMessage;

	public MessageResponse() {
	}

	public MessageResponse(String message) {
		this(Status.OK.getStatusCode(), message);
	}

	public MessageResponse(int code, String message) {
		this.setStatusCode(code);
		this.setStatusMessage(message);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
