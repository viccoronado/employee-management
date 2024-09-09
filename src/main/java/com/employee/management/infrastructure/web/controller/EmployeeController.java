package com.employee.management.infrastructure.web.controller;

import com.employee.management.application.dto.EmployeeRequestDto;
import com.employee.management.application.dto.EmployeeResponseDto;
import com.employee.management.domain.services.EmployeeService;
import com.employee.management.domain.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        try {
            EmployeeResponseDto responseDto = employeeService.createEmployee(employeeRequestDto);
            if (responseDto.getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmployeeResponseDto(null, false));
            }
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
