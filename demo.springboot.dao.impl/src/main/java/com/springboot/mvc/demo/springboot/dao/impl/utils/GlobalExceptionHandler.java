package com.springboot.mvc.demo.springboot.dao.impl.utils;


	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public String handleException(Exception e) {
	        // Log the exception
	        return "An error occurred: " + e.getMessage();
	    }
	}
