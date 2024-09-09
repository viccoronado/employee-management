package com.employee.management.domain.exceptions;

public class ExceedMaxWorkedHoursException extends RuntimeException {
  public ExceedMaxWorkedHoursException(String message) {
    super(message);
  }
}
