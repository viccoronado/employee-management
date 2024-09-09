package com.example.domain.exceptions;

public class EmployeesNotFoundException extends CustomException {
    public EmployeesNotFoundException(String message) {
        super(message);
    }
}