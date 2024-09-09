package com.example.domain.exceptions;

public class DuplicateTimeEntryException extends CustomException {
    public DuplicateTimeEntryException(String message) {
        super(message);
    }
}
