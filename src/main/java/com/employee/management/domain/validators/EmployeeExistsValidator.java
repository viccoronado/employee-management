package com.employee.management.domain.validators;

import com.employee.management.domain.exceptions.EmployeeNotFoundException;
import com.employee.management.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("employeeExistsValidator")
@RequiredArgsConstructor
public class EmployeeExistsValidator implements Validator<Long> {

    private final EmployeeRepository employeeRepository;

    @Override
    public void validate(Long employeeId) {
        if (!employeeRepository.employeeExists(employeeId)) {
            throw new EmployeeNotFoundException("Employee not found.");
        }
    }
}
