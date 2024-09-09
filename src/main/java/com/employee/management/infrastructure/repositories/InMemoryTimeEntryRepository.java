package com.employee.management.infrastructure.repositories;

import com.employee.management.domain.models.TimeEntry;
import com.employee.management.domain.repositories.TimeEntryRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> timeEntryStore = new HashMap<>();
    private long currentId = 1L;

    @Override
    public TimeEntry save(TimeEntry timeEntry) {
        if (timeEntry.getId() == null) {
            timeEntry.setId(currentId++);
        }
        timeEntryStore.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public Optional<TimeEntry> findByEmployeeIdAndWorkedDate(Long employeeId, LocalDate workedDate) {
        return timeEntryStore.values().stream()
                .filter(te -> te.getEmployeeId().equals(employeeId) && te.getWorkedDate().equals(workedDate))
                .findFirst();
    }

    @Override
    public double calculateTotalHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return timeEntryStore.values().stream()
                .filter(te -> te.getEmployeeId().equals(employeeId))
                .filter(te -> !te.getWorkedDate().isBefore(startDate) && !te.getWorkedDate().isAfter(endDate))
                .mapToDouble(TimeEntry::getWorkedHours)
                .sum();
    }

    @Override
    public Optional<TimeEntry> findById(Long id) {
        return Optional.ofNullable(timeEntryStore.get(id));
    }

    @Override
    public List<TimeEntry> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return timeEntryStore.values().stream()
                .filter(te -> te.getEmployeeId().equals(employeeId))
                .filter(te -> !te.getDate().isBefore(Instant.from(startDate)) && !te.getDate().isAfter(Instant.from(endDate)))
                .collect(Collectors.toList());
    }
}
