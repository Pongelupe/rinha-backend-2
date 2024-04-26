package br.com.ppongelupe.api.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler({BaseHttpException.class})
	public ResponseEntity<String> handleHttpException(BaseHttpException e) {
		return ResponseEntity.status(e.getStatus()).body(e.getMessage());
	}
	
}
