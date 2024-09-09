package com.employee.management.infrastructure.persistence;

import com.employee.management.domain.models.Employee;
import com.employee.management.domain.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

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
    public List<Employee> findByJobId(Long jobId) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeDatabase.values()) {
            if (employee.getJob().getId().equals(jobId)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public boolean jobExists(Long jobId) {
        return jobDatabase.containsKey(jobId);
    }

    @Override
    public Optional<Integer> getTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return Optional.of(40);
    }

    @Override
    public boolean employeeExists(Long employeeId) {
        return employeeDatabase.containsKey(employeeId);
    }

    @Override
    public Optional<Integer> getEmployeePayment(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return Optional.of(100);
    }
}
