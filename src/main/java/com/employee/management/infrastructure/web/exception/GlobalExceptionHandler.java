package com.employee.management.infrastructure.web.exception;

import com.employee.management.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handleEmployeeAlreadyExists(EmployeeAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidEmployeeAgeException.class)
    public ResponseEntity<String> handleInvalidEmployeeAge(InvalidEmployeeAgeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(GenderNotFoundException.class)
    public ResponseEntity<String> handleGenderNotFound(GenderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<String> handleJobNotFound(JobNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
