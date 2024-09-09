package com.employee.management.application.services;

import com.employee.management.application.dto.EmployeeRequestDto;
import com.employee.management.domain.exceptions.EmployeeAlreadyExistsException;
import com.employee.management.domain.exceptions.InvalidEmployeeAgeException;
import com.employee.management.domain.exceptions.GenderNotFoundException;
import com.employee.management.domain.exceptions.JobNotFoundException;
import com.employee.management.domain.models.Employee;
import com.employee.management.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeRequestDto requestDto) {
        validateEmployeeData(requestDto);

        Employee newEmployee = Employee.builder()
                .name(requestDto.getName())
                .lastName(requestDto.getLastName())
                .birthdate(requestDto.getBirthdate())
                .genderId(requestDto.getGenderId())
                .jobId(requestDto.getJobId())
                .build();

        return employeeRepository.save(newEmployee);
    }

    private void validateEmployeeData(EmployeeRequestDto requestDto) {
        if (employeeRepository.existsByNameAndLastName(requestDto.getName(), requestDto.getLastName())) {
            throw new EmployeeAlreadyExistsException("Employee with the same name and last name already exists.");
        }

        if (Period.between(requestDto.getBirthdate(), LocalDate.now()).getYears() < 18) {
            throw new InvalidEmployeeAgeException("Employee must be at least 18 years old.");
        }

        if (!employeeRepository.genderExists(requestDto.getGenderId())) {
            throw new GenderNotFoundException("The specified gender does not exist.");
        }

        if (!employeeRepository.jobExists(requestDto.getJobId())) {
            throw new JobNotFoundException("The specified job does not exist.");
        }
    }
}
