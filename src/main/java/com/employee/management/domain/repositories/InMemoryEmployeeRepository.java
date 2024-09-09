package com.employee.management.domain.repositories;

import com.employee.management.domain.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {
    private final Map<Long, Employee> employeeStorage = new HashMap<>();
    private long idCounter = 1;

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            long newId = idCounter++;
            employee = new Employee.Builder()
                    .withId(newId)
                    .withName(employee.getName())
                    .withLastName(employee.getLastName())
                    .withBirthDate(employee.getBirthDate())
                    .withGenderId(employee.getGenderId())
                    .withJobId(employee.getJobId())
                    .build();
        }

        employeeStorage.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Employee> findByJobId(Long jobId) {
        return List.of();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employeeStorage.get(id));
    }

    @Override
    public Optional<Employee> findByNameAndLastName(String firstName, String lastName) {
        return employeeStorage.values().stream()
                .filter(emp -> emp.getName().equals(firstName) && emp.getLastName().equals(lastName))
                .findFirst();
    }
}
