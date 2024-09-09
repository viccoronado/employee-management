package com.employee.management.domain.exceptions;

public class InvalidDateException extends CustomException {
    public InvalidDateException(String message) {
        super(message);
    }
}