package com.springboot.mvc.demo.springboot.dao.impl.advices;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<APIError> noSuchElementException(NoSuchElementException noSuch) {
	    APIError apiError = new APIError(HttpStatus.NOT_FOUND, "No Resource Found");
	    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
}
