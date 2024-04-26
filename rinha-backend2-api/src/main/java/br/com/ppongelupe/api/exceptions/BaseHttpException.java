package br.com.ppongelupe.api.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseHttpException extends RuntimeException {

	private static final long serialVersionUID = 6394266234150336814L;
	
	private final HttpStatus status;
	
	private final String message;

	public BaseHttpException(HttpStatus status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}
	
	

}
