package com.employee.management.domain.exceptions;

public class InvalidDateRangeException extends CustomException {
    public InvalidDateRangeException(String message) {
        super(message);
    }
}