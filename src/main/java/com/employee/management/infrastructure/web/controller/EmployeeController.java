package com.employee.management.infrastructure.web.controller;

import com.employee.management.application.dto.request.EmployeeHoursRequestDto;
import com.employee.management.application.dto.request.EmployeePaymentRequestDto;
import com.employee.management.application.dto.request.EmployeeRequestDto;
import com.employee.management.application.dto.request.JobIdRequestDto;
import com.employee.management.application.dto.response.EmployeeHoursResponseDto;
import com.employee.management.application.dto.response.EmployeePaymentResponseDto;
import com.employee.management.application.dto.response.EmployeeResponseDto;
import com.employee.management.application.services.EmployeeService;
import com.employee.management.domain.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/by-job")
    public ResponseEntity<List<EmployeeResponseDto>> getEmployeesByJob(@RequestParam Long jobId) {
        JobIdRequestDto requestDto = JobIdRequestDto.builder().jobId(jobId).build();
        List<EmployeeResponseDto> employees = employeeService.getEmployeesByJobId(requestDto);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/hours")
    public ResponseEntity<EmployeeHoursResponseDto> getTotalWorkedHours(
            @RequestParam Long employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        EmployeeHoursRequestDto requestDto = EmployeeHoursRequestDto.builder()
                .employeeId(employeeId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        EmployeeHoursResponseDto responseDto = employeeService.getTotalWorkedHours(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/payment")
    public ResponseEntity<EmployeePaymentResponseDto> getEmployeePayment(
            @RequestParam Long employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        EmployeePaymentRequestDto requestDto = EmployeePaymentRequestDto.builder()
                .employeeId(employeeId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        EmployeePaymentResponseDto responseDto = employeeService.getEmployeePayment(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
