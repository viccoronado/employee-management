package com.example.domain.repositories;

import com.example.domain.models.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findByNameAndLastName(String name, String lastName);
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    List<Employee> findByJobId(Long jobId);
}
