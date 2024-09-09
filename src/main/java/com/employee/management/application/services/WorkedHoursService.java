package com.employee.management.application.services;

import com.employee.management.application.dto.request.WorkedHoursRequestDto;
import com.employee.management.domain.exceptions.ExceedMaxWorkedHoursException;
import com.employee.management.domain.exceptions.DuplicateWorkedHoursException;
import com.employee.management.domain.models.WorkedHours;
import com.employee.management.domain.repositories.WorkedHoursRepository;
import com.employee.management.domain.validators.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkedHoursService {

    private static final int MAX_WORKED_HOURS = 20;
    private final WorkedHoursRepository workedHoursRepository;

    private final @Qualifier("employeeExistsValidator") Validator<Long> employeeExistsValidator;

    public WorkedHours addWorkedHours(WorkedHoursRequestDto requestDto) {
        validateWorkedHours(requestDto);

        WorkedHours workedHours = WorkedHours.builder()
                .id(UUID.randomUUID())
                .employeeId(requestDto.getEmployeeId())
                .workedHours(requestDto.getWorkedHours())
                .workedDate(requestDto.getWorkedDate())
                .build();

        return workedHoursRepository.save(workedHours);
    }

    private void validateWorkedHours(WorkedHoursRequestDto requestDto) {
        employeeExistsValidator.validate(requestDto.getEmployeeId());

        if (requestDto.getWorkedHours() > MAX_WORKED_HOURS) {
            throw new ExceedMaxWorkedHoursException("Worked hours cannot exceed 20 hours.");
        }

        if (requestDto.getWorkedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Worked date cannot be in the future.");
        }

        if (workedHoursRepository.existsByEmployeeAndDate(requestDto.getEmployeeId(), requestDto.getWorkedDate())) {
            throw new DuplicateWorkedHoursException("Worked hours record already exists for the given date.");
        }
    }
}
