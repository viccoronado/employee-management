package com.example.domain.exceptions;

public class JobNotFoundException extends CustomException {
    public JobNotFoundException(String message) {
        super(message);
    }
}