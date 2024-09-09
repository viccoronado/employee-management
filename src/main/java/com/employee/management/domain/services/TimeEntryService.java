package com.employee.management.domain.services;

import com.employee.management.application.dto.TimeEntryRequestDto;
import com.employee.management.application.dto.TimeEntryResponseDto;
import com.employee.management.domain.exceptions.*;
import com.employee.management.domain.models.TimeEntry;
import com.employee.management.domain.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;
    private final EmployeeRepository employeeRepository;

    public TimeEntryService(TimeEntryRepository timeEntryRepository,
                            EmployeeRepository employeeRepository) {
        this.timeEntryRepository = timeEntryRepository;
        this.employeeRepository = employeeRepository;
    }

    public TimeEntryResponseDto createTimeEntry(TimeEntryRequestDto timeEntryRequestDto) throws EmployeeNotFoundException, TimeEntryAlreadyExistsException {
        validateEmployeeExists(timeEntryRequestDto.getEmployeeId());
        validateTimeEntryUniqueness(timeEntryRequestDto.getEmployeeId(), timeEntryRequestDto.getWorkedDate());

        TimeEntry timeEntry = new TimeEntry(timeEntryRequestDto.getEmployeeId(), timeEntryRequestDto.getWorkedDate(), timeEntryRequestDto.getWorkedHours());
        TimeEntry savedTimeEntry = timeEntryRepository.save(timeEntry);

        return new TimeEntryResponseDto(savedTimeEntry.getId(), true);
    }

    private void validateEmployeeExists(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Employee not found for ID: " + employeeId);
        }
    }

    private void validateTimeEntryUniqueness(Long employeeId, LocalDate workedDate) {
        if (timeEntryRepository.findByEmployeeIdAndWorkedDate(employeeId, workedDate).isPresent()) {
            throw new TimeEntryAlreadyExistsException("Time entry already exists for this employee on the given date.");
        }
    }
}
