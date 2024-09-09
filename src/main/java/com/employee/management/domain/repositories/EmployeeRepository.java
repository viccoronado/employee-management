package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository {

    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    boolean existsById(Long id);
    List<Employee> findByJobId(Long jobId);
    Optional<Employee> findByNameAndLastName(String firstName, String lastName);
}
