package com.employee.management.domain.repositories;

import com.employee.management.domain.models.WorkedHours;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkedHoursRepository {
    WorkedHours save(WorkedHours workedHours);
    List<WorkedHours> findByEmployeeIdAndWorkedDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
    Optional<WorkedHours> findById(Long id);
}
