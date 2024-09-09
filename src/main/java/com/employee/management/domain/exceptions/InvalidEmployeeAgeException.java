package com.employee.management.domain.exceptions;

public class InvalidEmployeeAgeException extends RuntimeException {
    public InvalidEmployeeAgeException(String message) {
        super(message);
    }
}
