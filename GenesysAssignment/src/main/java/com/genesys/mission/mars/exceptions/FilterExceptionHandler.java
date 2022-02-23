package com.genesys.mission.mars.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FilterExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<Object> handleFilterException(Exception ex, WebRequest webRequest){
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
