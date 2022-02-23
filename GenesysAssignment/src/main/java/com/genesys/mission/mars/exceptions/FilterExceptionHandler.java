package com.genesys.mission.mars.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FilterExceptionHandler extends ResponseEntityExceptionHandler{

	Logger logger = LoggerFactory.getLogger(FilterExceptionHandler.class);
	
	@ExceptionHandler
	public ResponseEntity<Object> handleFilterException(Exception ex, WebRequest webRequest){
		logger.error("Encountered Exception - ", ex);
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
