package br.com.builders.dto;


/**
 * Classe genérica para resposta de serviço.
 * @author alexandre monteiro
 * @since 02/04/2021
 */
public class ResponseDTO {

	private Object data;
	
	private String message;
	
	public ResponseDTO() {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
