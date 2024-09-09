package com.employee.management.domain.repositories;

import com.employee.management.domain.models.WorkedHours;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryWorkedHoursRepository implements WorkedHoursRepository {

    private final Map<Long, WorkedHours> workedHoursStore = new HashMap<>();
    private long currentId = 1L;

    @Override
    public WorkedHours save(WorkedHours workedHours) {
        if (workedHours.getId() == null) {
            workedHours.setId(currentId++);
        }
        workedHoursStore.put(workedHours.getId(), workedHours);
        return workedHours;
    }

    @Override
    public Optional<WorkedHours> findById(Long id) {
        return Optional.ofNullable(workedHoursStore.get(id));
    }

    @Override
    public List<WorkedHours> findByEmployeeIdAndWorkedDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return workedHoursStore.values().stream()
                .filter(wh -> wh.getEmployeeId().equals(employeeId))
                .filter(wh -> !wh.getWorkedDate().isBefore(startDate) && !wh.getWorkedDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

}
