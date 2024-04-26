package br.com.ppongelupe.api.exceptions;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends BaseHttpException {

	private static final long serialVersionUID = -1599766385194687322L;

	public UnprocessableEntityException(String message) {
		super(HttpStatus.UNPROCESSABLE_ENTITY, message);
	}


}
