package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class WorkedHoursRequestDto {
    @NonNull
    private Long employeeId;

    @NonNull
    private Integer workedHours;

    @NonNull
    private LocalDate workedDate;
}
