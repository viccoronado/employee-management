package com.employee.management.domain.exceptions;

public class JobNotFoundException extends CustomException {
  public JobNotFoundException(String message) {
    super(message);
  }
}
