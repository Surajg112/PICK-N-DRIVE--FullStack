package com.pickndrive.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), webRequest.getDescription(false), new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Map<String, String>>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	 * 
	 * 
	 * Map<String, String> map = new HashMap<String, String>();
	 * 
	 * ex.getBindingResult().getAllErrors().forEach((error) -> {
	 * 
	 * String fieldName = ((FieldError) error).getField(); String message =
	 * error.getDefaultMessage(); map.put(fieldName, message); });
	 * 
	 * return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	 * 
	 * Map<String, String> resp = new HashMap<String, String>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> {
	 * 
	 * String fieldName = ((FieldError) error).getField(); String message =
	 * error.getDefaultMessage(); resp.put(fieldName, message); });
	 * 
	 * return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	 * }
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> resp = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		System.out.println(status.ordinal());
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handlerException(Exception ex, WebRequest webRequest) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), webRequest.getDescription(false), new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
