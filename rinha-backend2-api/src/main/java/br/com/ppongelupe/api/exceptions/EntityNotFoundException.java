package br.com.ppongelupe.api.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BaseHttpException {

	private static final long serialVersionUID = 6394266234150336814L;

	public EntityNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}
