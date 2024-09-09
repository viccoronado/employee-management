package com.employee.management.application.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
public class EmployeeHoursRequestDto {

    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonCreator
    public EmployeeHoursRequestDto(
            @JsonProperty("employeeId") Long employeeId,
            @JsonProperty("startDate") LocalDate startDate,
            @JsonProperty("endDate") LocalDate endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}