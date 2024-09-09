package com.employee.management.infrastructure.web.exception;

public final class ErrorMessages {

    private ErrorMessages() {
    }

    public static final String EMPLOYEE_ALREADY_EXISTS = "Employee already exists.";
    public static final String INVALID_EMPLOYEE_AGE = "Invalid employee age.";
    public static final String GENDER_NOT_FOUND = "Gender not found.";
    public static final String JOB_NOT_FOUND = "Job not found.";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found.";
    public static final String EXCEED_MAX_WORKED_HOURS = "Worked hours exceed the maximum limit.";
    public static final String DUPLICATE_WORKED_HOURS = "Duplicate worked hours record.";
    public static final String INVALID_DATE_RANGE = "Invalid date range.";
    public static final String INVALID_REQUEST_BODY = "Invalid request body.";
}
