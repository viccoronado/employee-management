package com.employee.management.infrastructure.web.controller;

import com.employee.management.application.dto.EmployeeRequestDto;
import com.employee.management.application.services.EmployeeService;
import com.employee.management.domain.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeService.addEmployee(employeeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
}
