package com.example.demo.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.errorResponse.ErrorResponse;
import com.example.demo.exception.EmployeeNotFoundException;

@ControllerAdvice
public class ControllerAdviceClass {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> controllerAdviceClass(EmployeeNotFoundException e) {
		ErrorResponse error = new ErrorResponse();
		error.setHttpstatus(HttpStatus.BAD_REQUEST);
		error.setMessage(e.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);

	}

}
