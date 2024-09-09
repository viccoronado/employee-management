package com.employee.management.domain.exceptions;

public class InvalidPaymentDataException extends CustomException {
    public InvalidPaymentDataException(String message) {
        super(message);
    }
}