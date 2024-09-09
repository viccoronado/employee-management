package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    boolean existsByNameAndLastName(String name, String lastName);
    boolean genderExists(Long genderId);
    List<Employee> findByJobId(Long jobId);
    boolean jobExists(Long jobId);
    Optional<Integer> getTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate);
    boolean employeeExists(Long employeeId);
    Optional<Integer> getEmployeePayment(Long employeeId, LocalDate startDate, LocalDate endDate);
}
