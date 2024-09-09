package com.employee.management.domain.validators;

@FunctionalInterface

public interface Validator<T> {
    void validate(T input);
}
