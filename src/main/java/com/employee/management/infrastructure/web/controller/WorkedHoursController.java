package com.employee.management.infrastructure.web.controller;

import com.employee.management.application.dto.request.WorkedHoursRequestDto;
import com.employee.management.application.services.WorkedHoursService;
import com.employee.management.domain.models.WorkedHours;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worked-hours")
@RequiredArgsConstructor
public class WorkedHoursController {

    private final WorkedHoursService workedHoursService;

    @PostMapping
    public ResponseEntity<WorkedHours> addWorkedHours(@RequestBody WorkedHoursRequestDto requestDto) {
        WorkedHours workedHours = workedHoursService.addWorkedHours(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(workedHours);
    }
}
