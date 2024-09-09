package com.employee.management.domain.exceptions;

public class InvalidEmployeeAgeException extends CustomException {
    public InvalidEmployeeAgeException(String message) {
        super(message);
    }
}