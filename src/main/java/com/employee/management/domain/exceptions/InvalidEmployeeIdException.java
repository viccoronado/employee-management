package com.employee.management.domain.exceptions;

public class InvalidEmployeeIdException extends CustomException {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}