package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class EmployeeHoursRequestDto {
    @NonNull
    private Long employeeId;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate endDate;
}
