package com.employee.management.infrastructure.web.exception;

import com.employee.management.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<String> handleEmployeeAlreadyExists(EmployeeAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.EMPLOYEE_ALREADY_EXISTS);
    }

    @ExceptionHandler(InvalidEmployeeAgeException.class)
    public ResponseEntity<String> handleInvalidEmployeeAge(InvalidEmployeeAgeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.INVALID_EMPLOYEE_AGE);
    }

    @ExceptionHandler(GenderNotFoundException.class)
    public ResponseEntity<String> handleGenderNotFound(GenderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.GENDER_NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<String> handleJobNotFound(JobNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.JOB_NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessages.EMPLOYEE_NOT_FOUND);
    }

    @ExceptionHandler(ExceedMaxWorkedHoursException.class)
    public ResponseEntity<String> handleExceedMaxWorkedHours(ExceedMaxWorkedHoursException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.EXCEED_MAX_WORKED_HOURS);
    }

    @ExceptionHandler(DuplicateWorkedHoursException.class)
    public ResponseEntity<String> handleDuplicateWorkedHours(DuplicateWorkedHoursException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.DUPLICATE_WORKED_HOURS);
    }

    @ExceptionHandler(InvalidDateRangeException.class)
    public ResponseEntity<String> handleInvalidDateRange(InvalidDateRangeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessages.INVALID_DATE_RANGE);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessages.INVALID_REQUEST_BODY + ": " + ex.getMessage());
    }
}