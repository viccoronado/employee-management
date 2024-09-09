package com.employee.management.domain.repositories;

import org.springframework.stereotype.Repository;
import com.employee.management.domain.models.TimeEntry;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TimeEntryRepository {

    TimeEntry save(TimeEntry timeEntry);
    Optional<TimeEntry> findByEmployeeIdAndWorkedDate(Long employeeId, LocalDate workedDate);
    double calculateTotalHours(Long employeeId, LocalDate startDate, LocalDate endDate);

}