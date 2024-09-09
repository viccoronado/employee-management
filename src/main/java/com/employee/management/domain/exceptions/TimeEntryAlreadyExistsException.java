package com.employee.management.domain.exceptions;

public class TimeEntryAlreadyExistsException extends RuntimeException {
    public TimeEntryAlreadyExistsException(String message) {
        super(message);
    }
}
