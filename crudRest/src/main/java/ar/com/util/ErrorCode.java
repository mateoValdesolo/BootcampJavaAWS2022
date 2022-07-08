package ar.com.util;

public enum ErrorCode {
	INFO_INCOMPLETE(1, "Información incompleta"),
	BO_ERROR(2, "Bussines Exception");
	
	private int code;
	
	private String description;
	
	private ErrorCode(int code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
