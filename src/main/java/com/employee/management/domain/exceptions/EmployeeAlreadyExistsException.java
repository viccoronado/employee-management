package com.employee.management.domain.exceptions;

public class EmployeeAlreadyExistsException extends CustomException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
