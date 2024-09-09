package com.employee.management.infrastructure.persistence;

import com.employee.management.domain.models.Employee;
import com.employee.management.domain.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<Long, Employee> employeeDatabase = new HashMap<>();
    private final Map<Long, String> genderDatabase = new HashMap<>();
    private final Map<Long, String> jobDatabase = new HashMap<>();

    @Override
    public Employee save(Employee employee) {
        employeeDatabase.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public boolean existsByNameAndLastName(String name, String lastName) {
        return employeeDatabase.values().stream()
                .anyMatch(emp -> emp.getName().equals(name) && emp.getLastName().equals(lastName));
    }

    @Override
    public boolean genderExists(Long genderId) {
        return genderDatabase.containsKey(genderId);
    }

    @Override
    public boolean jobExists(Long jobId) {
        return jobDatabase.containsKey(jobId);
    }
}
