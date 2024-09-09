package com.employee.management.domain.repositories;

import com.employee.management.domain.models.WorkedHours;

import java.time.LocalDate;

public interface WorkedHoursRepository {
    WorkedHours save(WorkedHours workedHours);

    boolean employeeExists(Long employeeId);

    boolean existsByEmployeeAndDate(Long employeeId, LocalDate date);
}
