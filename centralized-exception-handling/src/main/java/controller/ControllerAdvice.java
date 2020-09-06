package controller;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import exception.model.ErrorDetails;
import exceptions.ComplexNotFoundException;
import exceptions.NoDataFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(NoDataFoundException.class)
    public final ResponseEntity<ErrorDetails> handleCustomException1(NoDataFoundException ce, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ce.getMessage(), new Timestamp(System.currentTimeMillis()),
			      ce.getStackTrace(), request.getDescription(false));
			  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ComplexNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCustomException2(ComplexNotFoundException ce, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ce.getMessage(), new Timestamp(System.currentTimeMillis()),
				ce.getStackTrace(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}
}
