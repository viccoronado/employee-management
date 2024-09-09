package com.employee.management.infrastructure.repositories;

import com.employee.management.domain.models.WorkedHours;
import com.employee.management.domain.repositories.WorkedHoursRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryWorkedHoursRepository implements WorkedHoursRepository {
    private final List<WorkedHours> workedHoursList = new ArrayList<>();

    @Override
    public List<WorkedHours> findByEmployeeIdAndWorkedDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return workedHoursList.stream()
                .filter(wh -> wh.getEmployeeId().equals(employeeId) && !wh.getWorkedDate().isBefore(startDate) && !wh.getWorkedDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkedHours> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public WorkedHours save(WorkedHours workedHours) {
        workedHoursList.add(workedHours);
        return workedHours;
    }

    public void addWorkedHours(WorkedHours workedHours) {
        workedHoursList.add(workedHours);
    }
}
