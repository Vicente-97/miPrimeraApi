package com.jacaranda.primerSpring.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class elementNotFoundException extends RuntimeException {


	public elementNotFoundException(Integer id) {
		super("No se puede encontrar el elemnto con id=" + id);	
	}

	public elementNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public elementNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public elementNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public elementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
