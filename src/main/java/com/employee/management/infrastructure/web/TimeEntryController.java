package com.employee.management.infrastructure.web;

import com.employee.management.application.dto.TimeEntryRequestDto;
import com.employee.management.application.dto.TimeEntryResponseDto;
import com.employee.management.domain.exceptions.*;
import com.employee.management.domain.services.TimeEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping
    public ResponseEntity<TimeEntryResponseDto> createTimeEntry(@RequestBody TimeEntryRequestDto timeEntryRequestDto) {
        try {
            TimeEntryResponseDto responseDto = timeEntryService.createTimeEntry(timeEntryRequestDto);
            return ResponseEntity.ok(responseDto);
        } catch (EmployeeNotFoundException | InvalidWorkedHoursException | InvalidDateException | TimeEntryAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TimeEntryResponseDto(null, false));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TimeEntryResponseDto(null, false));
        }
    }
}
