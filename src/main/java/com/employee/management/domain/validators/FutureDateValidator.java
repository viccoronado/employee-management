package com.employee.management.domain.validators;

import java.time.LocalDate;

@FunctionalInterface
public interface FutureDateValidator extends Validator<LocalDate> {}