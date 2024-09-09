package com.example.domain.exceptions;

public abstract class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
