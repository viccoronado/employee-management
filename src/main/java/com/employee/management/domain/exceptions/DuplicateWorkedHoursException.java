package com.employee.management.domain.exceptions;

public class DuplicateWorkedHoursException extends RuntimeException {
    public DuplicateWorkedHoursException(String message) {
        super(message);
    }
}
