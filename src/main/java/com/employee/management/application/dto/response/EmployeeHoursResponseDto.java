package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeHoursResponseDto {
    private Integer totalWorkedHours;
    private Boolean success;
}
