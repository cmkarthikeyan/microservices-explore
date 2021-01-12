package com.cmk.micro.services.employee.controller.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cmk.micro.services.employee.service.exception.EmployeeNotFoundException;



@RestControllerAdvice
public class RestExceptionHandler {

	

	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handleBindException(BindException ex, WebRequest request) {
		
		StringBuilder errorMessage = new StringBuilder();
		ex.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage() + ". "));
		return new ResponseEntity(
				ExceptionResponse.builder().timeStamp(new Date()).message("Validation failed")
						.details(errorMessage.toString()).uri(request.getDescription(false)).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<List> handleProductNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		return new ResponseEntity(
				ExceptionResponse.builder().timeStamp(new Date()).message(ex.getMessage())
						.details(request.getDescription(false)).uri(request.getDescription(false)).build(),
				HttpStatus.BAD_REQUEST);
	}

}
