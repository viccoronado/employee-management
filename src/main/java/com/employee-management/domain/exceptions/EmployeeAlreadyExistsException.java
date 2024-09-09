package com.example.domain.exceptions;

public class EmployeeAlreadyExistsException extends CustomException {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
