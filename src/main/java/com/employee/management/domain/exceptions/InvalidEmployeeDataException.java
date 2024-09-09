package com.employee.management.domain.exceptions;

public class InvalidEmployeeDataException extends CustomException {
    public InvalidEmployeeDataException(String message) {
        super(message);
    }
}
