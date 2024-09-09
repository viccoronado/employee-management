package com.employee.management.domain.exceptions;

public class InvalidJobIdException extends CustomException {
    public InvalidJobIdException(String message) {
        super(message);
    }
}
