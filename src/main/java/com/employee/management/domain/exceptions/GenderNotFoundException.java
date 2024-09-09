package com.employee.management.domain.exceptions;

public class GenderNotFoundException extends RuntimeException {
  public GenderNotFoundException(String message) {
    super(message);
  }
}
