package com.ratanaphoneshop.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handleApiException(APIExecption e){
		ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(errorResponse);
	}
}
