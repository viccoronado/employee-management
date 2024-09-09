package com.employee.management.domain.exceptions;

public class CustomException extends RuntimeException {
  public CustomException(String message) {
    super(message);
  }
}
