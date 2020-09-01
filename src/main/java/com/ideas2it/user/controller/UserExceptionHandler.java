package com.ideas2it.user.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleUsernameNotException(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
	}

}
