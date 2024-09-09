package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);
    boolean existsByNameAndLastName(String name, String lastName);
    boolean genderExists(Long genderId);
    boolean jobExists(Long jobId);
}
