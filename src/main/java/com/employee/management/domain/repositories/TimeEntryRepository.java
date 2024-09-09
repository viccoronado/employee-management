package com.employee.management.domain.repositories;

import org.springframework.stereotype.Repository;
import com.employee.management.domain.models.TimeEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeEntryRepository {

    Optional<TimeEntry> findById(Long id);
    TimeEntry save(TimeEntry timeEntry);
    Optional<TimeEntry> findByEmployeeIdAndWorkedDate(Long employeeId, LocalDate workedDate);
    double calculateTotalHours(Long employeeId, LocalDate startDate, LocalDate endDate);
    List<TimeEntry> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}