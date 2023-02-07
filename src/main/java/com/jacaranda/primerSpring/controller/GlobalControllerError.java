package com.jacaranda.primerSpring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jacaranda.primerSpring.model.ApiError;
import com.jacaranda.primerSpring.model.elementNotFoundException;

@RestControllerAdvice
public class GlobalControllerError {

	@ExceptionHandler(elementNotFoundException.class)
	public ResponseEntity<ApiError> handleElementNotFoundException(elementNotFoundException e) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Te has equivocado amigo");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
}
