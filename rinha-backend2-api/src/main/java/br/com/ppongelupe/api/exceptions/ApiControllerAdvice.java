package br.com.ppongelupe.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler({BaseHttpException.class})
	public ResponseEntity<String> handleHttpException(BaseHttpException e) {
		return ResponseEntity.status(e.getStatus()).body(e.getMessage());
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<String> handleHttpException(MethodArgumentNotValidException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
	}
	
}
