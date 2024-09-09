package com.employee.management.domain.validators;

import com.employee.management.domain.exceptions.InvalidDateRangeException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateRangeValidator implements Validator<LocalDate[]> {
    @Override
    public void validate(LocalDate[] dateRange) {
        if (dateRange[0].isAfter(dateRange[1])) {
            throw new InvalidDateRangeException("Start date must be before end date.");
        }
    }
}
