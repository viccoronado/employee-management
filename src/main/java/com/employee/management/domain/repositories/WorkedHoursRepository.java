package com.employee.management.domain.repositories;

import com.employee.management.domain.models.WorkedHours;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkedHoursRepository {
    List<WorkedHours> findByEmployeeIdAndWorkedDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}
