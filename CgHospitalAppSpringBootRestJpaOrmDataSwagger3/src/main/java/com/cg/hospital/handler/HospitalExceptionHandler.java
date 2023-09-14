package com.cg.hospital.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.hospital.exceptions.PatientDetailsNotFoundException;

@ControllerAdvice
public class HospitalExceptionHandler {

	@ExceptionHandler(value = PatientDetailsNotFoundException.class)
	public ResponseEntity<String> handleProductDetailNotFoundException(PatientDetailsNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
		
}