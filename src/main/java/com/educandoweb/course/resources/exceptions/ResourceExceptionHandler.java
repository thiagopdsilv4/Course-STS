package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)//resourceNotFound intercepta qualquer excessao do tipo ResourceNotFOundException e fazer o tratamento
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());//status.value()para passar para inteiro
		return ResponseEntity.status(status).body(er);
	}
	
	@ExceptionHandler(DataBaseException.class)//resourceNotFound intercepta qualquer excessao do tipo ResourceNotFOundException e fazer o tratamento
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());//status.value()para passar para inteiro
		return ResponseEntity.status(status).body(er);
	}
}

