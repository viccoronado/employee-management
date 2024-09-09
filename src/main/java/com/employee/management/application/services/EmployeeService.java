package com.employee.management.application.services;

import com.employee.management.application.dto.request.EmployeeHoursRequestDto;
import com.employee.management.application.dto.request.EmployeePaymentRequestDto;
import com.employee.management.application.dto.request.EmployeeRequestDto;
import com.employee.management.application.dto.request.JobIdRequestDto;
import com.employee.management.application.dto.response.EmployeeHoursResponseDto;
import com.employee.management.application.dto.response.EmployeePaymentResponseDto;
import com.employee.management.application.dto.response.EmployeeResponseDto;
import com.employee.management.domain.models.Employee;
import com.employee.management.domain.repositories.EmployeeRepository;
import com.employee.management.domain.validators.DateRangeValidator;
import com.employee.management.domain.validators.EmployeeAgeValidator;
import com.employee.management.domain.validators.EmployeeExistsValidator;
import com.employee.management.domain.validators.JobExistsValidator;
import com.employee.management.application.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeAgeValidator employeeAgeValidator;
    private final EmployeeExistsValidator employeeExistsValidator;
    private final DateRangeValidator dateRangeValidator;
    private final JobExistsValidator jobExistsValidator;
    private final EmployeeMapper employeeMapper;

    public Employee addEmployee(EmployeeRequestDto requestDto) {
        jobExistsValidator.validate(requestDto.getJobId());
        validateEmployeeData(requestDto);
        Employee newEmployee = employeeMapper.toEntity(requestDto);
        return employeeRepository.save(newEmployee);
    }

    private void validateEmployeeData(EmployeeRequestDto requestDto) {
        employeeAgeValidator.validate(requestDto);
        jobExistsValidator.validate(requestDto.getJobId());
    }

    public List<EmployeeResponseDto> getEmployeesByJobId(JobIdRequestDto requestDto) {
        jobExistsValidator.validate(requestDto.getJobId());

        List<Employee> employees = employeeRepository.findByJobId(requestDto.getJobId());

        return employeeMapper.toEmployeeResponseDtoList(employees);
    }

    public EmployeeHoursResponseDto getTotalWorkedHours(EmployeeHoursRequestDto requestDto) {
        employeeExistsValidator.validate(requestDto.getEmployeeId());
        dateRangeValidator.validate(new LocalDate[]{requestDto.getStartDate(), requestDto.getEndDate()});

        Integer totalWorkedHours = employeeRepository.getTotalWorkedHours(
                requestDto.getEmployeeId(),
                requestDto.getStartDate(),
                requestDto.getEndDate()
        ).orElse(null);

        return EmployeeHoursResponseDto.builder()
                .totalWorkedHours(totalWorkedHours)
                .success(totalWorkedHours != null)
                .build();
    }

    public EmployeePaymentResponseDto getEmployeePayment(EmployeePaymentRequestDto requestDto) {
        employeeExistsValidator.validate(requestDto.getEmployeeId());
        dateRangeValidator.validate(new LocalDate[]{requestDto.getStartDate(), requestDto.getEndDate()}); // Validador para rango de fechas

        Integer payment = employeeRepository.getEmployeePayment(
                requestDto.getEmployeeId(),
                requestDto.getStartDate(),
                requestDto.getEndDate()
        ).orElse(null);

        return EmployeePaymentResponseDto.builder()
                .payment(payment)
                .success(payment != null)
                .build();
    }
}