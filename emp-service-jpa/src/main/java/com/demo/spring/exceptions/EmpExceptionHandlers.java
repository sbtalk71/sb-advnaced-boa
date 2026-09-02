package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.util.MessageResponse;

@RestControllerAdvice
public class EmpExceptionHandlers {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<MessageResponse> handleEmpNotFound(EmployeeNotFoundException ex){
		return ResponseEntity.status(404).body(new MessageResponse(ex.getMessage()));
	}
	
	@ExceptionHandler(EmployeeExistsException.class)
	public ResponseEntity<MessageResponse> handleEmpExists(EmployeeExistsException ex){
		return ResponseEntity.ok(new MessageResponse(ex.getMessage()));
	}
}
