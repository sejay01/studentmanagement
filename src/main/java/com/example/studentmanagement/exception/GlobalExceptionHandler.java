package com.example.studentmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request){
            String errorMessage = ex.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
