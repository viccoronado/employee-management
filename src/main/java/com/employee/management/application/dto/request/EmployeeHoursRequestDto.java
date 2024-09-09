package com.employee.management.application.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@JsonDeserialize(using = EmployeeHoursRequestDtoDeserializer.class)
public class EmployeeHoursRequestDto {

    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;

    public EmployeeHoursRequestDto(Long employeeId, LocalDate startDate, LocalDate endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
