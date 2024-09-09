package com.employee.management.domain.exceptions;

public class EmployeeNotFoundException extends CustomException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}