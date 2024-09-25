package com.joey.DSHC.handleErrors;

import com.joey.DSHC.exceptions.CommentNotFoundException;
import com.joey.DSHC.exceptions.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> exceptionHandler (Exception exception) {
        this.shoeLogError("Exception", exception);
        ErrorResponse<String> threatResponse = new ErrorResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> runtimeExceptionHandler (RuntimeException exception) {
        this.shoeLogError("RuntimeException", exception);
        ErrorResponse<String> threatResponse = new ErrorResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    private ResponseEntity<String> commentNotFoundExceptionHandler (CommentNotFoundException exception) {
        this.shoeLogError("CommentNotFoundException", exception);
        ErrorResponse<String> threatResponse = new ErrorResponse<>(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    @ExceptionHandler(InvalidArgumentException.class)
    private ResponseEntity<String> invalidArgumentExceptionHandler (InvalidArgumentException exception) {
        this.shoeLogError("InvalidArgumentException", exception);
        ErrorResponse<String> threatResponse = new ErrorResponse<>(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(threatResponse.httpStatus()).body("ControllerAdvice - " + threatResponse.body());
    }

    private void shoeLogError (String name, Exception exception) {
        LOGGER.error("Error: {} - {}", name, exception.getMessage());
        LOGGER.error("Error: {} cause - {}", name, String.valueOf(exception.getCause()));
        LOGGER.error("Error: {} toString - {}", name, exception.toString());
    }
}
