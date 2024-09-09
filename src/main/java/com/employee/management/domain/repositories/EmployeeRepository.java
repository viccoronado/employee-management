package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByNameAndLastName(String name, String lastName);
    Optional<Employee> findById(Long id);
    List<Employee> findByJobId(Long jobId);
}
