package com.employee.management.infrastructure.persistence;

import com.employee.management.domain.models.WorkedHours;
import com.employee.management.domain.repositories.WorkedHoursRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class WorkedHoursRepositoryImpl implements WorkedHoursRepository {

    private Map<UUID, WorkedHours> workedHoursDatabase = new HashMap<>();
    private final Map<Long, Boolean> employeeDatabase = new HashMap<>();

    @Override
    public WorkedHours save(WorkedHours workedHours) {
        workedHoursDatabase.put(workedHours.getId(), workedHours);
        return workedHours;
    }

    @Override
    public boolean employeeExists(Long employeeId) {
        return employeeDatabase.containsKey(employeeId);
    }

    @Override
    public boolean existsByEmployeeAndDate(Long employeeId, LocalDate date) {
        return workedHoursDatabase.values().stream()
                .anyMatch(wh -> wh.getEmployeeId().equals(employeeId) && wh.getWorkedDate().equals(date));
    }
}
