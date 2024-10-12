package com.springboot.mvc.demo.springboot.dao.impl.advices;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIError {

	private HttpStatus status;
	private String message;
	public APIError(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}