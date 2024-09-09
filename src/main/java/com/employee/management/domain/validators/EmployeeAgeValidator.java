package com.employee.management.domain.validators;

import com.employee.management.application.dto.request.EmployeeRequestDto;
import com.employee.management.domain.exceptions.InvalidEmployeeAgeException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EmployeeAgeValidator implements Validator<EmployeeRequestDto> {
    @Override
    public void validate(EmployeeRequestDto requestDto) {
        if (Period.between(requestDto.getBirthdate(), LocalDate.now()).getYears() < 18) {
            throw new InvalidEmployeeAgeException("Employee must be at least 18 years old.");
        }
    }
}
