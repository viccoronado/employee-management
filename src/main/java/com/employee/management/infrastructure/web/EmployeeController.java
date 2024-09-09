package com.employee.management.infrastructure.web;

import com.employee.management.application.dto.EmployeeRequestDto;
import com.employee.management.application.dto.EmployeeResponseDto;
import com.employee.management.domain.exceptions.*;
import com.employee.management.domain.models.Employee;
import com.employee.management.domain.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            if (employeeRequestDto == null) {
                throw new InvalidRequestBodyException("Request body must not be null.");
            }

            if (employeeRequestDto.getName() == null || employeeRequestDto.getLastName() == null ||
                    employeeRequestDto.getDateOfBirth() == null || employeeRequestDto.getGenderId() == null ||
                    employeeRequestDto.getJobId() == null) {
                throw new InvalidEmployeeDataException("All employee fields must be provided.");
            }

            EmployeeResponseDto responseDto = employeeService.createEmployee(employeeRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);

        } catch (InvalidEmployeeDataException | InvalidEmployeeAgeException |
                 GenderNotFoundException | JobNotFoundException | EmployeeAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmployeeResponseDto(null, false));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmployeeResponseDto(null, false));
        }
    }

    @GetMapping("/by-job")
    public ResponseEntity<List<Employee>> getEmployeesByJob(@RequestParam Long jobId) {
        try {
            if (jobId == null || jobId <= 0) {
                throw new InvalidJobIdException("Job ID must be a positive number.");
            }

            List<Employee> employees = employeeService.getEmployeesByJob(jobId);

            if (employees.isEmpty()) {
                throw new EmployeeNotFoundException("No employees found for the given job ID.");
            }

            return ResponseEntity.ok(employees);

        } catch (InvalidJobIdException | EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());

        } catch (JobNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{employeeId}/hours")
    public ResponseEntity<?> getTotalHoursWorked(
            @PathVariable Long employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        try {
            if (employeeId == null || employeeId <= 0) {
                throw new InvalidEmployeeIdException("Employee ID must be a positive number.");
            }

            if (startDate == null || endDate == null) {
                throw new InvalidDateRangeException("Start date and end date must be provided.");
            }

            double totalHours = employeeService.calculateTotalHoursWorked(employeeId, startDate, endDate);
            return ResponseEntity.ok(totalHours);

        } catch (InvalidEmployeeIdException | InvalidDateRangeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}