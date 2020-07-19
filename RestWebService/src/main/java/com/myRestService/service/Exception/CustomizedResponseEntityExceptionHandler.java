package com.myRestService.service.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController // adding this coz, we want to apply this geeric exception to all rest controllerclasses
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	// this is for general exception. We can do similarly for or custumized exception also. eg : UserNotFoundException
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		GenericResponseExceptionFormat genericResponseExceptionFormat = new GenericResponseExceptionFormat(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity(genericResponseExceptionFormat, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		
		GenericResponseExceptionFormat genericResponseExceptionFormat = new GenericResponseExceptionFormat(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity(genericResponseExceptionFormat, HttpStatus.NOT_FOUND);
	}
	
	// for validation, if we get the incorrect data: eg: name : A, dirthdate is not past date then we will get : 400 bad request, Coz of @Valid and @Size, @Past.
	// to custumized the response structure: override below method:
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		GenericResponseExceptionFormat genericResponseExceptionFormat = new GenericResponseExceptionFormat(new Date(), ex.getBindingResult().toString(), request.getDescription(false));
		
		
		return new ResponseEntity(genericResponseExceptionFormat, HttpStatus.BAD_REQUEST);
	}//no needt throw this exception. it is default handle by spring boot exception handling mechanism.
	
}
