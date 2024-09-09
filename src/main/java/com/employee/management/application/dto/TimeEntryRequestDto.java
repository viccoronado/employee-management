package com.employee.management.application.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Builder
@Getter
public class TimeEntryRequestDto {
    private final Long employeeId;
    private final Double workedHours;
    private final LocalDate workedDate;
}
